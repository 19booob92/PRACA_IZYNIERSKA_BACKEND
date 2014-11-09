package sample.data.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.model.Results;
import sample.data.jpa.service.ResultsService;


@Controller
@RequestMapping(value = "/stats")
public class StatsController {

    @Autowired
    ResultsService resultsService;

    @RequestMapping(value = "/statsForUser/{pageNum}", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Results> messages(@PathVariable Integer pageNum) {
        Page<Results> page = resultsService.getAllResults(pageNum);
        return page.getContent();
    }
}
