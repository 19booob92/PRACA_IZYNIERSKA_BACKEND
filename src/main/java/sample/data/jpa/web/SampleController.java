package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/asd", method = RequestMethod.GET)
    public @ResponseBody String dupa() {
        return "asdasdsad";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody String createMsg(Question question) {
        questService.addQuestion(question);
        return "asdasdsad";
    }
}
