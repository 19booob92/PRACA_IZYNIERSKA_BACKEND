package com.pwr.quizzer.service;



public interface AuthoritiesService {
    
    void deleteAuthority(String username);
    
    String getAuthorityForUser(String username);
}
