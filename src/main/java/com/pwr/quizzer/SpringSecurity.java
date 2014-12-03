package com.pwr.quizzer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import com.pwr.quizzer.utils.Authorities;


@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/*", "/logout", "/login", "/users/role").permitAll()
                .antMatchers("/test/**").access("hasRole('" + Authorities.STUDENT + "')")
                .antMatchers("/test/courseName/").access("hasRole('" + Authorities.LECTOR + "')")
                .antMatchers("/users/**").access("hasRole('" + Authorities.ADMIN + "')")
                .antMatchers("/quest/**").access("hasRole('" + Authorities.LECTOR + "')")
                .antMatchers("/stats/**").access("hasRole('" + Authorities.LECTOR + "')")
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().accessDeniedPage("/login");
        http
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .csrf().disable()
                .logout()
                .permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
        userDetailsService.setDataSource(dataSource);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        auth.jdbcAuthentication().authoritiesByUsernameQuery(
                "select username, authority as role from authorities where username=?");
    }
}
