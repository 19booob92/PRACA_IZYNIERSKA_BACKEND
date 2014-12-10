package com.pwr.quizzer.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.pwr.quizzer.dto.UserDTO;
import com.pwr.quizzer.model.UserTmp;
import com.pwr.quizzer.service.AuthoritiesService;

@Component
public class UserMapper {

    @Autowired
    private AuthoritiesService authService;
    
    public UserDTO mapUser(UserTmp user) {
        UserDTO userDto = new UserDTO();
        userDto.setAble(user.getAble());
        userDto.setEnabled(user.isEnabled());
        userDto.setUsername(user.getUsername());
        userDto.setRole(authService.getAuthorityForUser(user.getUsername()));
        userDto.setIndexNo(user.getIndexNo());
        
        return userDto;
    }
    
    public List<UserDTO> mapUsersList(Page<UserTmp> userList) {
        List<UserDTO> usersDtoList = new ArrayList<UserDTO>();
        for (UserTmp user : userList) {
            if (!user.getUsername().equals("admin")) {
                usersDtoList.add(mapUser(user));
            }
        }
        return usersDtoList;
    }
    
}
