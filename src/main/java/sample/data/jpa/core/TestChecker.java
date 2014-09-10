package sample.data.jpa.core;

import org.springframework.stereotype.Component;

import sample.data.dto.QuestionDTO;
import sample.data.jpa.model.Question;

@Component
public class TestChecker {
    
    public int checkQuestions() {
        
    }
    
    int points = 0;
    for (QuestionDTO quest : question) {
        Question questFromDb = questService.getOneQuestion((long)quest.getId());
        if (quest.getTick().equals(questFromDb.getCorrectAnswer())) {
            points += questFromDb.getPoints();
        }
    }
}
