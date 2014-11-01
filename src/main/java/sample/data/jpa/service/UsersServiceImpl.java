package sample.data.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import sample.data.jpa.model.Users;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    DataSource dataSource;

    JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();
    PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public void createUser(Users user) {
        userDetailsService.setDataSource(dataSource);

        if (!userDetailsService.userExists(user.getUserName())) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(user.getAuth()));
            User userDetails = new User(user.getUserName(), encoder.encode(user.getPassword()), authorities);

            userDetailsService.createUser(userDetails);
        }
    }

    @Override
    public void deleteUser(String userName) {

    }

}
