package sample.data.jpa.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.dto.MarkDTO;
import sample.data.dto.QuestionDTO;
import sample.data.jpa.model.Question;
import sample.data.jpa.service.QuestionService;


@Controller
@RequestMapping(value = "/quest")
public class QuestController {

    @Autowired
    QuestionService questService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Question getQuestion(@PathVariable Long id) {
        return questService.getOneQuestion(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAllQuestions(Model model) {
        model.addAttribute("questions", questService.getAllQuestions());
        return "editQuestion";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createMsg(@ModelAttribute("question") Question question, BindingResult result, Model model) {
        questService.addQuestion(question);
        return "addQuestion";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = "application/json")
    public String deleteMsg(@RequestBody List<QuestionDTO> ids) {
        for (QuestionDTO questId : ids) {
            questService.deleteQuestion(questId.getId());
        }
        return "editQuestion";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String quests(@PathVariable long id, Model model) {
            Question quest = questService.getOneQuestion(id);
            model.addAttribute("editQuest", quest);
            return "editQuestById";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String quests(@ModelAttribute("questions") Question quest, BindingResult result, Model model) {
        questService.addQuestion(quest);
        return "";
    }

}
