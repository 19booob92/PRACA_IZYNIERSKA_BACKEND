//package sample.data.core;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
//import sample.data.dto.QuestionDTO;
//import sample.data.jpa.model.Question;
//
//
//
//public class TestBase {
//
//    protected List<QuestionDTO> fakeList;
//    protected List<QuestionDTO> shortFakeList;
//    
//    protected void createQuestions() {
//        
//        fakeList = new ArrayList<>();
//        shortFakeList = new ArrayList<>();
//
//        QuestionDTO quest = new QuestionDTO();
//        quest.setId(0);
//        quest.setContent("Pytanie");
//        
//        QuestionDTO quest1 = new QuestionDTO();
//        quest.setId(1);
//        quest.setContent("Pytanie1");
//        
//        QuestionDTO quest2 = new QuestionDTO();
//        quest.setId(2);
//        quest.setContent("Pytanie2");
//        
//        QuestionDTO quest3 = new QuestionDTO();
//        quest.setId(3);
//        quest.setContent("Pytanie3");
//        
//        QuestionDTO quest4 = new QuestionDTO();
//        quest.setId(4);
//        quest.setContent("Pytanie4");
//
//        QuestionDTO quest5 = new QuestionDTO();
//        quest.setId(5);
//        quest.setContent("Pytanie5");
//        
//        fakeList.add(quest);
//        fakeList.add(quest1);
//        fakeList.add(quest2);
//        fakeList.add(quest3);
//        fakeList.add(quest4);
//        fakeList.add(quest5);
//        
//        shortFakeList.add(quest);
//        shortFakeList.add(quest1);
//        shortFakeList.add(quest2);
//    }
//}
