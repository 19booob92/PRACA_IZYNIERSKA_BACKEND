package com.pwr.quizzer.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pwr.quizzer.dto.EditQuestionDTO;
import com.pwr.quizzer.model.CourseGenere;
import com.pwr.quizzer.model.Users;

@Controller
public class ViewController {
    
    @RequestMapping(value = "/")
    public String mainView() {
        return "home";
    }

    @RequestMapping(value = "/quest/addQuestion")
    public String questionView(Model model) {
        model.addAttribute("answer", new EditQuestionDTO());
        return "addQuestion";
    }
    
    @RequestMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/userCreation")
    public String usersCreate(Users user) {
        return "addUser";
    }

    @RequestMapping(value = "/users/usersMng")
    public String usersManage() {
        return "usersMng";
    }
    
    @RequestMapping(value = "/courseMng")
    public String courseManager() {
        return "courseMng";
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

    @RequestMapping(value = "/addCourse")
    public String addCourse(CourseGenere courseGenere) {
        return "addCourse";
    }
    
}
