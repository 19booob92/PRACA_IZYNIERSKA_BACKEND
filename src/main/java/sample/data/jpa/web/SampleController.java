package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.model.Question;
import sample.data.jpa.service.QuestionService;


@Controller
@RequestMapping(value = "/quest")
public class SampleController {

    @Autowired
    QuestionService questService;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public @ResponseBody Question questionId(@PathVariable Long id) {
        return questService.getOneQuestion(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody String createMsg(Question question) {
        questService.addQuestion(question);
        return "Created";
    }
 
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody String deleteMsg(Question question) {
        questService.addQuestion(question);
        return "Deleted";
    }
       
}
