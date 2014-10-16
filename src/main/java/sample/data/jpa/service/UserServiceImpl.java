package sample.data.jpa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.data.jpa.model.User;
import sample.data.jpa.repository.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;
    
    @Override
    public User findByUserName(String login) {
        return userRepo.findByLogin(login);
    }
}
