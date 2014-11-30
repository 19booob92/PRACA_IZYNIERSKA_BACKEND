package com.pwr.quizzer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pwr.quizzer.service.CourseService;


@Controller
@RequestMapping(value = "/courses")
public class CoursesController {
    
    @Autowired
    private CourseService courseService;
    
    @RequestMapping(value = "", method = RequestMethod.GET )
    public String getCoursesList(Model model) {
        model.addAttribute("groups", courseService.findAll());
        return "testsGroups";
    }

}
