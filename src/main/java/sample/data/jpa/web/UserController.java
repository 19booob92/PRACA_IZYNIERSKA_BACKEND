package sample.data.jpa.web;

import net.spy.memcached.tapmessage.RequestMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
