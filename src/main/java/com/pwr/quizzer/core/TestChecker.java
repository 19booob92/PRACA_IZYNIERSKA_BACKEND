package com.pwr.quizzer.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pwr.quizzer.dto.QuestionDTO;
import com.pwr.quizzer.dto.ResultDTO;
import com.pwr.quizzer.model.Question;
import com.pwr.quizzer.service.QuestionService;
import com.pwr.quizzer.service.ResultsService;


@Component
public class TestChecker {

    @Autowired
    private QuestionService questService;

    @Autowired
    private ResultsService resultsService;
    
    public ResultDTO checkQuestions(List<QuestionDTO> question) {
        int points = 0, questAmount = 0;
        boolean[] answersBool = new boolean[question.size()];
        int  maxPoints = 0;
        
        for (QuestionDTO quest : question) {
            
            Question questFromDb = questService.getOneQuestion((long) quest.getId());
            
            maxPoints += questFromDb.getPoints();
            
            if (quest.getTick().equals(questFromDb.getCorrectAnswer())) {
                answersBool[questAmount] = true;
                points += questFromDb.getPoints();
            } else {
                answersBool[questAmount] = false;
            }
            questAmount++;
        }
        
        return new ResultDTO(answersBool, points, maxPoints, resultsService.evaluateMark(points, maxPoints));
    }

}
