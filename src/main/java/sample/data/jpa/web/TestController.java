package sample.data.jpa.web;

import java.awt.geom.IllegalPathStateException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import sample.data.dto.AnswerDTO;
import sample.data.dto.QuestionDTO;
import sample.data.dto.ResultDTO;
import sample.data.jpa.core.TestChecker;
import sample.data.jpa.core.TestCreator;
import sample.data.jpa.model.Results;
import sample.data.jpa.service.QuestionService;
import sample.data.jpa.service.ResultsService;


@Controller
public class TestController {

    private static final int AMOUNT = 3; // FIXME

    @Autowired
    TestCreator testCreator;

    @Autowired
    TestChecker testChecker;

    @Autowired
    QuestionService questService;

    @Autowired
    ResultsService resultsService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String messages(Model model) {
        try {
            model.addAttribute("test", testCreator.createTest(AMOUNT));
            return "test";
        } catch (IllegalArgumentException e) {
            return "errorPage";
        }
    }

    @RequestMapping(value = "/checkTest", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String check(@RequestBody AnswerDTO questions, Authentication authentication) {
        ResultDTO testResult = testChecker.checkQuestions(questions.getQuestions());
        persistResult(questions, authentication, testResult);
        Gson gson = new Gson();
        return gson.toJson(testResult);
    }

    private void persistResult(AnswerDTO questions, Authentication authentication, ResultDTO testResult) {
        Results result = new Results();
        result.setPoints(testResult.getPoints());
        result.setTestId(questions.getTestId());
        result.setStudentId(authentication.getName());
        result.setMark(testResult.getMark());
        result.setMaxPoints(testResult.getMaxPoints());

        resultsService.addResult(result);
    }
}
