package sample.data.core;

import java.util.ArrayList;
import java.util.List;

import com.pwr.quizzer.model.Question;


public class TestBase {

    protected List<Question> fakeList;
    protected List<Question> shortFakeList;

    protected void createQuestions() {
        
        fakeList = new ArrayList<Question>();
        shortFakeList = new ArrayList<Question>();

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

        Question quest6 = new Question();
        quest.setId(6);
        quest.setContent("Pytanie6");
        
        Question quest7 = new Question();
        quest.setId(7);
        quest.setContent("Pytanie7");
        
        Question quest8 = new Question();
        quest.setId(8);
        quest.setContent("Pytanie8");
        
        Question quest9 = new Question();
        quest.setId(9);
        quest.setContent("Pytanie9");
        
        Question quest10 = new Question();
        quest.setId(10);
        quest.setContent("Pytanie10");
        
        Question quest11 = new Question();
        quest.setId(11);
        quest.setContent("Pytanie11");
        
        fakeList.add(quest);
        fakeList.add(quest1);
        fakeList.add(quest2);
        fakeList.add(quest3);
        fakeList.add(quest4);
        fakeList.add(quest5);
        fakeList.add(quest6);
        fakeList.add(quest7);
        fakeList.add(quest8);
        fakeList.add(quest9);
        fakeList.add(quest10);
        fakeList.add(quest11);

        shortFakeList.add(quest);
        shortFakeList.add(quest1);
        shortFakeList.add(quest2);
    }
}
