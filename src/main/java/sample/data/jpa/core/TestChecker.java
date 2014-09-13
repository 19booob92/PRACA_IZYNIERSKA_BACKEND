package sample.data.jpa.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.data.dto.QuestionDTO;
import sample.data.jpa.model.Question;
import sample.data.jpa.service.QuestionService;


@Component
public class TestChecker {

    @Autowired
    private QuestionService questService;
    
    public int checkQuestions(List<QuestionDTO> question) {
        int points = 0;
        for (QuestionDTO quest : question) {
            Question questFromDb = questService.getOneQuestion((long) quest.getId());
            if (quest.getTick().equals(questFromDb.getCorrectAnswer())) {
                points += questFromDb.getPoints();
            }
        }
        return points;
    }

}
