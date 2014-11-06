package sample.data.jpa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "/courses")
public class CoursesController {
    
    @RequestMapping(value = "", method = RequestMethod.GET )
    public String getCoursesList() {
        return null;
    }
}
