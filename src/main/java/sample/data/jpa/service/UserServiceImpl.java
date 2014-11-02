package sample.data.jpa.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.data.jpa.model.UserTmp;
import sample.data.jpa.repository.UsersRepo;

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
