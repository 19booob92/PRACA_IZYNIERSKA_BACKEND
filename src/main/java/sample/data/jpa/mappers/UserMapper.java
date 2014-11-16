package sample.data.jpa.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import sample.data.dto.UserDTO;
import sample.data.jpa.model.UserTmp;

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
