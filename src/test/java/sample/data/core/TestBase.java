package sample.data.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sample.data.dto.QuestionDTO;
import sample.data.jpa.model.Question;



public class TestBase {

    protected List<Question> fakeList;
    protected List<Question> shortFakeList;
    
    protected void createQuestions() {
        
        fakeList = new ArrayList<>();
        shortFakeList = new ArrayList<>();

        Question quest = new Question();
        quest.setId(0);
        quest.setContent("Pytanie");
        
        Question quest1 = new Question();
        quest.setId(1);
        quest.setContent("Pytanie1");
        
        Question quest2 = new Question();
        quest.setId(2);
        quest.setContent("Pytanie2");
        
        Question quest3 = new Question();
        quest.setId(3);
        quest.setContent("Pytanie3");
        
        Question quest4 = new Question();
        quest.setId(4);
        quest.setContent("Pytanie4");

        Question quest5 = new Question();
        quest.setId(5);
        quest.setContent("Pytanie5");
        
        fakeList.add(quest);
        fakeList.add(quest1);
        fakeList.add(quest2);
        fakeList.add(quest3);
        fakeList.add(quest4);
        fakeList.add(quest5);
        
        shortFakeList.add(quest);
        shortFakeList.add(quest1);
        shortFakeList.add(quest2);
    }
}
