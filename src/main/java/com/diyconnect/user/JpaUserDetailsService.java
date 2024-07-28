package com.diyconnect.user;

import com.diyconnect.exception.userException.UserNotFoundException;
import com.diyconnect.userRole.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = userService.findByUsername(username);

        if(userOptional.isEmpty()){
            throw new UserNotFoundException();
        }

        User user = userOptional.get();
        List<UserRole> userRoles = user.getUserRoles();

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        userRoles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole().getName()));
        });

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                authorities
        );
    }
}
