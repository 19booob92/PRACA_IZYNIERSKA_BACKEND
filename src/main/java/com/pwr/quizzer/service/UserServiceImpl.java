package com.pwr.quizzer.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwr.quizzer.model.UserTmp;
import com.pwr.quizzer.repository.UsersRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UsersRepo userRepo;
    
    @Override
    public UserTmp findByUserName(String login) {
        return userRepo.findByUsername(login);
    }

}
