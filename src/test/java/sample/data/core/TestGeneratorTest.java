//package sample.data.core;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.mockito.Matchers.*;
//
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import sample.data.jpa.core.TestCreator;
//import sample.data.jpa.model.Question;
//import sample.data.jpa.service.QuestionService;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TestGeneratorTest extends TestBase {
//    
//    @Mock
//    private TestCreator testCreator;
//
//    @Mock
//    private QuestionService questService;
//    
//    @Before
//    public void init() {
//        Mockito.doCallRealMethod().when(testCreator).createTest(Mockito.anyInt());
//        initData();
////        testCreator.questService = questService;
////        when(testCreator.createTest(Mockito.anyInt())).thenCallRealMethod();
//    }
//    
//    private void initData() {
//        testCreator = new TestCreator();
//        
//        fakeList = new ArrayList<Question>();
//        shortFakeList = new ArrayList<Question>();
//
//        Question quest = new Question();
//        quest.setId(0);
//        quest.setContent("Pytanie");
//        
//        Question quest1 = new Question();
//        quest.setId(1);
//        quest.setContent("Pytanie1");
//        
//        Question quest2 = new Question();
//        quest.setId(2);
//        quest.setContent("Pytanie2");
//        
//        Question quest3 = new Question();
//        quest.setId(3);
//        quest.setContent("Pytanie3");
//        
//        Question quest4 = new Question();
//        quest.setId(4);
//        quest.setContent("Pytanie4");
//
//        Question quest5 = new Question();
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
//    
//    @Test
//    public void shouldReturnGeneratedTestWithDataFromDataBase() {
//        // given
//        when(questService.getAllQuestions()).thenReturn(fakeList);
//        int questionsAmount = 5;
//        // when
//        List<Question> questionsInTest = testCreator.createTest(questionsAmount);
//        // then
//        assertThat(questionsInTest.size()).isEqualTo(5);
//    }
//
//    @Test
//    public void shouldEvalueteTestDifficult() {
//        // given
//
//        // when
//
//        // then
////        assertFalse(1 == 1);
//    }
//
//    @Test
//    public void shouldEvaluatePointsForUser() {
//        // given
//
//        // when
//
//        // then
////        assertFalse(1 == 1);
//    }
//
//    @Test
//    public void shouldReturnTrueWhenTestsDifficultIsSimilar() {
//        // given
//
//        // when
//
//        // then
////        assertFalse(1 == 1);
//    }
//
//    @Test
//    public void shouldReturnTrueWhenAllQuestsInTestAreDifferent() {
//        // given
//        when(questService.getAllQuestions()).thenReturn(fakeList);
//        int questionsAmount = 5;
//        // when
//        List<Question> questionsInTest = testCreator.createTest(questionsAmount);
//        // then
//        assertThat(questionsInTest).doesNotHaveDuplicates();
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void shouldThrowException() {
//        // given
//        when(questService.getAllQuestions()).thenReturn(shortFakeList);
//        int questionsAmount = 5;
//        // when
//        List<Question> questionsInTest = testCreator.createTest(questionsAmount);
//        // then
//        assertThat(questionsInTest).doesNotHaveDuplicates();
//    }
//
//}
