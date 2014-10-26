package sample.data.jpa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping(value = "/")
    public String mainView() {
        return "home";
    }

    @RequestMapping(value = "/addQuestion")
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

    @RequestMapping(value = "/editUsers")
    public String usersManage() {
        return "editUsers";
    }
    
}
