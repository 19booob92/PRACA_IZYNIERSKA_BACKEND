package com.pwr.quizzer.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pwr.quizzer.model.CourseGenere;
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

    @RequestMapping(value = "/courseGenereForLector")
    public String getPageWithCourse(Model model) {
        model.addAttribute("groups", courseService.findAll());
        return "testsGroupsForLector";
    }
    
    @RequestMapping(value = "/create")
    public String addCourse(@Valid CourseGenere courseGenere, BindingResult result, Model model) {
        model.addAttribute("course", new CourseGenere());
        if (result.hasErrors()) {
            return "addCourse";
        } else {
            courseService.save(courseGenere);
            return "redirect:/addCourse";
        }
    }
    
    @RequestMapping(value = "/allCourses")
    public @ResponseBody List<CourseGenere> getCourseList() {
        return courseService.findAll();
    }
    
}
