package sample.data.jpa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebMvcSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/*", "/logout", "/login").permitAll()
                .antMatchers("/test/**").hasRole("LECTOR")
                .anyRequest().authenticated();  
        http
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .csrf().disable()
                .logout()
                .permitAll();
    }


    @Configuration
    protected static class AuthenticationConfiguration extends
            GlobalAuthenticationConfigurerAdapter {

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser("user").password("password").roles("LECTOR");
        }

    }

}
