package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sample.data.jpa.service.ResultsService;


@Controller
@RequestMapping(value = "/stats")
public class StatsController {

    @Autowired
    ResultsService resultsService;
    
    @RequestMapping(value = "/statsForUser", method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute("statsUsr", resultsService.getAllResults());
        return "stats";
    }
}
