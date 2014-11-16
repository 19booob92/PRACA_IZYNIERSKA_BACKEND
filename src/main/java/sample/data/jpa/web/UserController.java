package sample.data.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.dto.UserDTO;
import sample.data.jpa.model.UserTmp;
import sample.data.jpa.model.Users;
import sample.data.jpa.service.UsersService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UsersService usersService;
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("users") Users user, BindingResult result, Model model) {
        usersService.createUser(user);
        return "userCreation";
    }
    
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public @ResponseBody String getUserRole(Authentication authentication) {
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            return authority.getAuthority(); 
        }
        return "";
    }
    
    @RequestMapping(value = "/delete/{userName}", method = RequestMethod.DELETE)
    public String deleteMsg(@PathVariable String userName) {
        usersService.deleteUser(userName);
        return "editUser";
    }
    
    @RequestMapping(value = "/edit/{username}", method = RequestMethod.GET)
    public String quests(@PathVariable String username, Model model) {
            UserTmp user = usersService.getUser(username);
            model.addAttribute("editUser", user);
            return "editUserByName";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String users(@ModelAttribute("users") UserTmp user) {
        usersService.updateUser(user);
        return "redirect:/userDelete";
    }
    
    @RequestMapping(value = "/getAll/{pageNum}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<UserDTO> getAllUsers(@PathVariable Integer pageNum) {
        Page<UserDTO> userPages = usersService.getAllUsers(pageNum);
        return userPages.getContent();
    }
}
