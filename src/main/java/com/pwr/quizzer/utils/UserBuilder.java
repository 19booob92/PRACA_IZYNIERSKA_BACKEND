package com.pwr.quizzer.utils;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

public class UserBuilder {

    private UserBuilder() {

    }

    public static void persistUser(String name, String pass, Authorities auth, DataSource dataSource) {
        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(dataSource);
        PasswordEncoder encoder = new BCryptPasswordEncoder();

            List<GrantedAuthority> authorities = new
                    ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(auth.toString()));
            User userDetails = new User(name, encoder.encode(pass),
                    authorities);

            userDetailsService.createUser(userDetails);
    }

}
