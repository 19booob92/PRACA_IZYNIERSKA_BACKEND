package sample.data.jpa.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.dto.AnswerDTO;
import sample.data.dto.ResultDTO;
import sample.data.jpa.core.TestChecker;
import sample.data.jpa.core.TestCreator;
import sample.data.jpa.model.Results;
import sample.data.jpa.service.QuestionService;
import sample.data.jpa.service.ResultsService;
import sample.data.jpa.service.UsersService;

import com.google.gson.Gson;


@Controller
public class TestController {

    public static final int QUEST_AMOUNT = 10; // FIXME

    @Autowired
    TestCreator testCreator;

    @Autowired
    TestChecker testChecker;

    @Autowired
    QuestionService questService;

    @Autowired
    ResultsService resultsService;
    
    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/test/courseName/{name}", method = RequestMethod.GET)
    public String generateTest(@PathVariable String name, Model model, Authentication auth, HttpSession session) {
        try {
            if (usersService.getUser(auth.getName()).isAble()) {
                model.addAttribute("test", testCreator.createTest(name));
                return "test";
            } else {
                session.setAttribute("errorTxt", "Już rozwiązałeś test !");
                return "errorPage";
            }
        } catch (IllegalArgumentException e) {
            session.setAttribute("errorTxt", "W bazie nie ma wystarczającej ilości pytań ! Ilość pytań : " + e.getMessage());
            return "errorPage";
        }
    }
   
    @RequestMapping(value = "/checkTest", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String check(@RequestBody AnswerDTO questions, Authentication authentication) {
        ResultDTO testResult = testChecker.checkQuestions(questions.getQuestions());
        persistResult(questions, authentication, testResult);

        usersService.disableUser(authentication.getName());
        
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
