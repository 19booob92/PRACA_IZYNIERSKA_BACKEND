package sample.data.jpa.service;

import sample.data.jpa.model.Users;
import sample.data.jpa.utils.Authorities;


public interface UsersService {
    
    void createUser(Users user);
    
    void deleteUser(String userName);
}
