package sample.data.jpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import sample.data.jpa.model.UserTmp;
import sample.data.jpa.model.Users;
import sample.data.jpa.repository.UsersRepo;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    DataSource dataSource;
    
    @Autowired
    UsersRepo usersRepo;

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

    @Override
    public void disableUser(String name) {
        UserTmp user = getUser(name);
        user.setAble(false);
        usersRepo.save(user);
    }

    @Override
    public UserTmp getUser(String userName) {
        return usersRepo.findByUsername(userName);
    }

}
