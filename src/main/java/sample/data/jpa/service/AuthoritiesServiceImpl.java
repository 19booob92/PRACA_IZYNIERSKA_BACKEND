package sample.data.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.data.jpa.repository.AuthoritiesRepo;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{

    @Autowired
    private AuthoritiesRepo authRepo;
    
    @Override
    public void deleteAuthority(String username) {
        authRepo.deleteAuthorityByUserName(username);
    }


}
