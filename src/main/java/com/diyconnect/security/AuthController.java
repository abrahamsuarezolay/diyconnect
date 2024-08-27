package com.diyconnect.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.diyconnect.security.TokenJWTConfig.SECRET_KEY;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/verifytoken")
    public void verifyToken(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String token = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("authToken")) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        if (token != null && !token.isEmpty()) {
            try {
                // Parse and verify the token
                Claims claims = Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload();

                // If valid, return HTTP 200 OK
                response.setStatus(HttpServletResponse.SC_OK);
            } catch (JwtException e) {
                // If invalid, return HTTP 401 Unauthorized
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            // No token present, return HTTP 401 Unauthorized
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
