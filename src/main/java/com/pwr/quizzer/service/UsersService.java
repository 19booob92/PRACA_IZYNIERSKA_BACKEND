package com.pwr.quizzer.service;

import org.springframework.data.domain.Page;

import com.pwr.quizzer.dto.UserDTO;
import com.pwr.quizzer.model.UserTmp;
import com.pwr.quizzer.model.Users;


public interface UsersService {
    
    void createUser(Users user);
    
    void deleteUser(String userName);

    void disableUser(String name, String courseGroup);
    
    UserTmp getUser(String userName);
    
    boolean isAbleToResolveTest(String userName, String courseGroup);

    Page<UserDTO> getAllUsers(Integer pageNum);

    void updateUser(UserTmp user);
}
