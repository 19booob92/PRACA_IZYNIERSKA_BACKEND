package sample.data.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.dto.QuestionDTO;
import sample.data.jpa.core.TestChecker;
import sample.data.jpa.core.TestCreator;
import sample.data.jpa.service.QuestionService;


@Controller
public class TestController {

    private static final int AMOUNT = 3; // FIXME

    @Autowired
    TestCreator testCreator;

    @Autowired
    TestChecker testChecker;

    @Autowired
    QuestionService questService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute("test", testCreator.createTest(AMOUNT));
        return "test";
    }

    @RequestMapping(value = "/checkTest", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String check(@RequestBody List<QuestionDTO> questions) {
        // save test to db with mark
        return String.valueOf(testChecker.checkQuestions(questions));
    }
}
