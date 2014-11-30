package com.pwr.quizzer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwr.quizzer.repository.AuthoritiesRepo;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{

    @Autowired
    private AuthoritiesRepo authRepo;
    
    @Override
    public void deleteAuthority(String username) {
        authRepo.deleteAuthorityByUserName(username);
    }

    @Override
    public String getAuthorityForUser(String username) {
        return authRepo.findOne(username).getAuthority();
    }


}
