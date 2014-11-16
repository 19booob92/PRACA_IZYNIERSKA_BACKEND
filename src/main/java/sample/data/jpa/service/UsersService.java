package sample.data.jpa.service;

import org.springframework.data.domain.Page;

import sample.data.dto.UserDTO;
import sample.data.jpa.model.UserTmp;
import sample.data.jpa.model.Users;


public interface UsersService {
    
    void createUser(Users user);
    
    void deleteUser(String userName);

    void disableUser(String name, String courseGroup);
    
    UserTmp getUser(String userName);
    
    boolean isAble(String userName, String courseGroup);

    Page<UserDTO> getAllUsers(Integer pageNum);

    void updateUser(UserTmp user);
}
