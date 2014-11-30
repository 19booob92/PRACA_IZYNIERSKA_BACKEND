package com.pwr.quizzer.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.pwr.quizzer.dto.UserDTO;
import com.pwr.quizzer.model.UserTmp;

@Component
public class UserMapper {

    public UserDTO mapUser(UserTmp user) {
        UserDTO userDto = new UserDTO();
        userDto.setAble(user.getAble());
        userDto.setEnabled(user.isEnabled());
        userDto.setUsername(user.getUsername());
        
        return userDto;
    }
    
    public List<UserDTO> mapUsersList(Page<UserTmp> userList) {
        List<UserDTO> usersDtoList = new ArrayList<>();
        for (UserTmp user : userList) {
            if (!user.getUsername().equals("admin")) {
                usersDtoList.add(mapUser(user));
            }
        }
        return usersDtoList;
    }
    
}
