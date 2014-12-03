package com.pwr.quizzer.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pwr.quizzer.dto.EditQuestionDTO;
import com.pwr.quizzer.mappers.QuestionMapper;
import com.pwr.quizzer.model.Question;
import com.pwr.quizzer.service.QuestionService;

@Controller
@RequestMapping(value = "/quest")
public class QuestController {

    private static final int FIRST_PAGE = 1;
    
    @Autowired
    QuestionService questService;

    @Autowired
    QuestionMapper questMapper;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Question getQuestion(@PathVariable Long id) {
        return questService.getOneQuestion(id);
    }

    @RequestMapping(value = "/getAll/{courseName}/{pageNum}", method = RequestMethod.GET)
    public @ResponseBody List<Question> getAllQuestions(@PathVariable Integer pageNum, @PathVariable String courseName) {
        Page<Question> questsPages = questService.getAllQuestions(courseName, pageNum);
        return questsPages.getContent();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createMsg(@Valid @ModelAttribute("answer") EditQuestionDTO question, BindingResult result,
            Model model) {
        String errorTxt = "";
        if (result.hasErrors()) {
            if (result.getFieldError("points") != null) {
                errorTxt += "Ilość punktów powinna nalezeć do przedziału <1, 8> ! \n";
            }
            if (result.getFieldError("correctAnswer") != null) {
                errorTxt += "Nie zaznaczyłeś poprawnej odpowiedzi ! \n";
            }
            model.addAttribute("error", errorTxt);
            model.addAttribute("answer", question);
            return "addQuestion";
        }
        model.addAttribute("answer", new EditQuestionDTO());
        questService.addQuestion(question);
        return "addQuestion";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteMsg(@PathVariable int id) {
            questService.deleteQuestion(id);
        return "editQuestion";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String quests(@PathVariable long id, Model model) {
        EditQuestionDTO quest = questMapper.Question2EditQuestionDTO(questService.getOneQuestion(id));
        model.addAttribute("questions", quest);
        return "editQuestById";
    }
    
    @RequestMapping(value = "/editQuestion/{courseName}")
    public String editQuestionPage(Model model, @PathVariable String courseName) {
        model.addAttribute("courseName", courseName);
        return "editQuestion";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String quests(@Valid @ModelAttribute("questions") EditQuestionDTO quest, BindingResult result, Model model) {
        String errorTxt = "";
        if (result.hasErrors()) {
            if (result.getFieldError("points") != null) {
                errorTxt += "Ilość punktów powinna nalezeć do przedziału <1, 8> ! \n";
            } else {
                errorTxt = "Nie wypełniono wszystkich pól";
            }
            
            if (result.getFieldError("correctAnswer") != null) {
                errorTxt += "Nie zaznaczyłeś poprawnej odpowiedzi ! \n";
            } else {
                errorTxt = "Nie wypełniono wszystkich pól";
            }
            
            model.addAttribute("error", errorTxt);
            model.addAttribute("questions", quest);
            model.addAttribute("quests", questService.getAllQuestions(quest.getCourseGenere(), FIRST_PAGE));
            return "editQuestion";
        }
        model.addAttribute("answer", new EditQuestionDTO());
        questService.editQuestion(quest);
        return "redirect:/quest/getAll";
    }
    
}
