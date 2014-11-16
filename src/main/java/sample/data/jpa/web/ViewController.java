package sample.data.jpa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    
    @RequestMapping(value = "/")
    public String mainView() {
        return "home";
    }

    @RequestMapping(value = "/quest/addQuestion")
    public String questionView() {
        return "addQuestion";
    }
    
    @RequestMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/editQuestion")
    public String editQuestionPage() {
        return "redirect:/quest/getAll";
    }

    @RequestMapping(value = "/userCreation")
    public String usersCreate() {
        return "userCreation";
    }

    @RequestMapping(value = "/users/usersMng")
    public String usersManage() {
        return "usersMng";
    }

    @RequestMapping(value = "/quest/questMng")
    public String questManage() {
        return "questMng";
    }

    @RequestMapping(value = "/stats/userStat")
    public String usersStats() {
        return "stats";
    }
    
    @RequestMapping(value = "/userDelete")
    public String editUsersPage() {
        return "editUser";
    }

}
