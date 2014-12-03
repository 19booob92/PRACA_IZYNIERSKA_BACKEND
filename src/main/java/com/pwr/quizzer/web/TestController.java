package com.pwr.quizzer.web;

import java.sql.Date;
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

import com.google.gson.Gson;
import com.pwr.quizzer.core.TestChecker;
import com.pwr.quizzer.core.TestCreator;
import com.pwr.quizzer.dto.AnswerDTO;
import com.pwr.quizzer.dto.QuestionDTO;
import com.pwr.quizzer.dto.ResultDTO;
import com.pwr.quizzer.model.Results;
import com.pwr.quizzer.model.Test;
import com.pwr.quizzer.service.QuestionService;
import com.pwr.quizzer.service.ResultsService;
import com.pwr.quizzer.service.TestService;
import com.pwr.quizzer.service.UsersService;


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

    Gson gson = new Gson();
    
    @RequestMapping(value = "/test/courseName/{name}", method = RequestMethod.GET)
    public String generateTest(@PathVariable String name, Model model, Authentication auth, HttpSession session) {

        try {
            if (usersService.isAble(auth.getName(), name)) {
                if (testService.getTestsByUsername(auth.getName(), name) != null
                        && testService.getTestsByUsername(auth.getName(), name).getUser() != null) {
                    Test tmpTest = testService.getTestsByUsername(auth.getName(), name);
                    
                    model.addAttribute("test", tmpTest.getQuestions());
                    model.addAttribute("testId", tmpTest.getId());
                    return "test";
                } else {
                    Test generatedTest = testCreator.createTest(name);
                    generatedTest.setUser(auth.getName());
                    generatedTest.setCourseGenere(name);
                    
                    testService.saveTest(generatedTest);
                    model.addAttribute("test", generatedTest.getQuestions());
                    model.addAttribute("testId", generatedTest.getId());
                    return "test";
                }
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

        testService.completeTestData(testResult.getPoints(), questions);

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

        long actualTime = System.currentTimeMillis();
        Date date = new Date(actualTime);

        result.setDate(date);

        resultsService.addResult(result);
    }

}
