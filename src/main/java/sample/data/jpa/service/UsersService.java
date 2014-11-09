package sample.data.jpa.service;

import sample.data.jpa.model.UserTmp;
import sample.data.jpa.model.Users;


public interface UsersService {
    
    void createUser(Users user);
    
    void deleteUser(String userName);

    void disableUser(String name);
    
    UserTmp getUser(String userName);
}
