package com.diyconnect.security;

import com.diyconnect.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.diyconnect.security.TokenJWTConfig.*;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        User user = null;
        String username = null;
        String password = null;

        try {
            //Leemos el cuerpo de la solicitud HTTP y convertimos el JSON en un objeto de tipo User usando ObjectMapper
            user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            username = user.getUsername();
            password = user.getPassword();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Creamos un token de autenticación que contiene las credenciales del usuario (nombre de usuario y contraseña)
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        // El AuthenticationManager se encarga de autenticar el token.
        // Internamente, utiliza el UserDetailsService para cargar los detalles del usuario desde la base de datos
        // y el PasswordEncoder (por ejemplo, BCryptPasswordEncoder) para codificar la contraseña proporcionada y compararla
        // con la contraseña codificada almacenada en la base de datos.
        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        //Este método maneja la respuesta que enviamos al usuario en caso de autenticación exitosa.

        //Aquí, obtenemos un UserDetails a partir del authResult.getPrincipal(). Esto nos devuelve un usuario ya que la autenticación ha sido exitosa.
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();

        //Para construir un token JWT, tenemos que convertir nuestras authorities de userDetails en Claims, para la librería de JWT. También añadimos el username.
        //Usamos un objectMapper, para convertir los authorities a tipo JSON
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        Claims claims = Jwts.claims()
                .add("authorities", new ObjectMapper().writeValueAsString(authorities))
                .add("username", user.getUsername())
                .build();

        //Usamos el Jwts.builder() para construir el token. Añadimos el subject(username), los claims, informacion de fechas y la clave secreta.
        String token = Jwts.builder().
                subject(user.getUsername())
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + 3600000))
                .issuedAt(new Date())
                .signWith(SECRET_KEY)
                .compact();

        //Generamos el header de la respuesta con el token.
        response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + token);

        //Generamos el cuerpo de la respuesta con mas informacion y el token de nuevo
        Map<String, String> body = new HashMap<>();
        body.put("token", token);
        body.put("username", user.getUsername());
        body.put("message", String.format("Hola %s, has iniciado sesión con éxito", user.getUsername()));

        //Escribimos el cuerpo de la respuesta como json
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setContentType(CONTENT_TYPE);
        response.setStatus(200);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException {

        //Manejo de respuesta en caso que attemptAuthentication no consiga autenticar al usuario con esas credenciales.

        Map<String, String> body = new HashMap<>();
        body.put("message", "Incorrect credentials");
        body.put("error", failed.getMessage());

        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setContentType(CONTENT_TYPE);
        response.setStatus(401);

    }
}
