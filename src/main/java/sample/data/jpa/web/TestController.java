package sample.data.jpa.web;

import java.util.List;

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
import sample.data.dto.QuestionDTO;
import sample.data.dto.ResultDTO;
import sample.data.jpa.core.TestChecker;
import sample.data.jpa.core.TestCreator;
import sample.data.jpa.model.Question;
import sample.data.jpa.model.Results;
import sample.data.jpa.model.Test;
import sample.data.jpa.service.QuestionService;
import sample.data.jpa.service.ResultsService;
import sample.data.jpa.service.TestService;
import sample.data.jpa.service.UsersService;

import com.google.gson.Gson;


@Controller
public class TestController {

    public static final int QUEST_AMOUNT = 10; // FIXME

    @Autowired
    private TestService testService;

    @Autowired
    private TestCreator testCreator;

    @Autowired
    private TestChecker testChecker;

    @Autowired
    private QuestionService questService;

    @Autowired
    private ResultsService resultsService;

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/test/courseName/{name}", method = RequestMethod.GET)
    public String generateTest(@PathVariable String name, Model model, Authentication auth, HttpSession session) {
        try {
            if (usersService.isAble(auth.getName(), name)) {
                Test generatedTest = testCreator.createTest(name);
                testService.saveTest(generatedTest);
                model.addAttribute("test", generatedTest.getQuestions());
                model.addAttribute("testId", generatedTest.getId());
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
        List<QuestionDTO> addQuestions = questions.getQuestions();

        ResultDTO testResult = testChecker.checkQuestions(addQuestions);
        persistResult(questions, authentication, testResult);

        String courseGroup = questService.recognizeCourseGroup(addQuestions);

        String user = authentication.getName();
        
        usersService.disableUser(user, courseGroup);

        testService.completeTestData(courseGroup, testResult.getPoints(), user, questions);

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
