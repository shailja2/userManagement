package com.user.userManagement.config;

import com.user.userManagement.dao.UserRepository;
import com.user.userManagement.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);

        if (userEntity != null) {
            return new org.springframework.security.core.userdetails.User(userEntity.getEmail(),
                    userEntity.getPwd(),
                    mapRoleToAuthorities(userEntity.getRole()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    /*private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(String role) {
        Collection < ? extends GrantedAuthority> mapRoles = role;
                //.map(role -> new SimpleGrantedAuthority(role.getName()))
                //.collect(Collectors.toList());
        return mapRoles;
    }*/

    private Collection<? extends GrantedAuthority> mapRoleToAuthorities(String role) {

        return List.of(new SimpleGrantedAuthority("ROLE_" + role));

    }


}

