package com.pwr.quizzer.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import com.pwr.quizzer.dto.UserDTO;
import com.pwr.quizzer.mappers.UserMapper;
import com.pwr.quizzer.model.UserTmp;
import com.pwr.quizzer.model.Users;
import com.pwr.quizzer.repository.UsersRepo;


@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private static final int ENTRIES_PER_PAGE = 5;

    @Autowired
    private AuthoritiesService authoritiesService;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UsersRepo usersRepo;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthoritiesService authService;

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
    public void deleteUser(String username) {
        authService.deleteAuthority(username);
        usersRepo.deleteUsersByUsername(username);
    }

    @Override
    public void disableUser(String name, String courseGroup) {
        UserTmp user = getUser(name);
        user.setAble(courseGroup);
        usersRepo.save(user);
    }

    @Override
    public UserTmp getUser(String userName) {
        return usersRepo.findByUsername(userName);
    }

    @Override
    public boolean isAble(String userName, String courseGroup) {
        List<String> solvedTestByCourseGroup = Lists.newArrayList(getUser(userName).getAble().split("\\,"));
        if (solvedTestByCourseGroup.contains(courseGroup) && !solvedTestByCourseGroup.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public Page<UserDTO> getAllUsers(Integer pageNum) {
        PageRequest request =
                new PageRequest(pageNum - 1, ENTRIES_PER_PAGE);

        Page<UserTmp> usersFromDB = usersRepo.findAll(request);
        List<UserDTO> mappedUsers = userMapper.mapUsersList(usersFromDB);
        Page<UserDTO> usersPages = new PageImpl<UserDTO>(mappedUsers);
        return usersPages;
    }

    @Override
    public void updateUser(UserTmp user) {
        if (user.getPassword().equals("*******")) {
            UserTmp actualUser = usersRepo.findByUsername(user.getUsername());
            usersRepo.updateUser(user.getUsername(), actualUser.getPassword(), user.getAble(), user.isEnabled());
        } else {
            usersRepo.updateUser(user.getUsername(), encoder.encode(user.getPassword()), user.getAble(), user.isEnabled());
        }
    }
}
