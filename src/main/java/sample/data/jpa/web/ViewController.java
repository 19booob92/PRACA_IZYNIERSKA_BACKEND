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

}
