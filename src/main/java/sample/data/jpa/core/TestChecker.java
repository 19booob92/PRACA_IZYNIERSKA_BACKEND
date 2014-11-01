package sample.data.jpa.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.data.dto.QuestionDTO;
import sample.data.dto.ResultDTO;
import sample.data.jpa.model.Question;
import sample.data.jpa.model.Results;
import sample.data.jpa.service.QuestionService;
import sample.data.jpa.service.ResultsService;


@Component
public class TestChecker {

    @Autowired
    private QuestionService questService;

    @Autowired
    private ResultsService resultsService;
    
    public ResultDTO checkQuestions(List<QuestionDTO> question) {
        int points = 0, i = 0;
        boolean[] answersBool = new boolean[question.size()];
        int  maxPoints = 0;
        
        for (QuestionDTO quest : question) {
            
            Question questFromDb = questService.getOneQuestion((long) quest.getId());
            
            maxPoints += questFromDb.getPoints();
            
            if (quest.getTick().equals(questFromDb.getCorrectAnswer())) {
                answersBool[i] = true;
                points += questFromDb.getPoints();
            } else {
                answersBool[i] = false;
            }
            i++;
        }
        
        return new ResultDTO(answersBool, points, maxPoints, resultsService.evaluateMark(points, maxPoints));
    }

}
