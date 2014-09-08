package sample.data.jpa.web;

import java.util.List;

import net.spy.memcached.tapmessage.RequestMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sample.data.jpa.core.TestCreator;
import sample.data.jpa.model.Question;
import sample.data.jpa.model.Test;

@Controller
public class TestController {
    
    private static final int AMOUNT = 3; //FIXME
    
    @Autowired
    TestCreator testCreator;
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute("test", testCreator.createTest(AMOUNT));
        return "test";
    }
    
    @RequestMapping(value = "/checkTest", method = RequestMethod.POST)
    public String check(@ModelAttribute("testToCheck") Test[] question, BindingResult result, Model model) {
        //check answers
        //save test to db with mark
        return "";
    }
}
