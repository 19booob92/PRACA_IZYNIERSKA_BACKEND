package sample.data.core;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.pwr.quizzer.core.TestCreator;
import com.pwr.quizzer.model.CourseGenere;
import com.pwr.quizzer.model.Question;
import com.pwr.quizzer.service.CourseService;


@RunWith(MockitoJUnitRunner.class)
public class TestGeneratorTest extends TestBase {

    @InjectMocks
    private TestCreator testCreator;

    @Mock
    public CourseService courseService;

    private CourseGenere courseGenre = new CourseGenere();
    
    @Before
    public void init() {
        courseGenre.setQuestions(fakeList);
        courseGenre.setName("Algebra");
        
        Mockito.when(courseService.findCourse("Algebra")).thenReturn(courseGenre);
        
        initData();
    }

    private void initData() {
        testCreator = new TestCreator();

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

    @Test
    public void shouldReturnGeneratedTestWithDataFromDataBaseWithoutDuplicates() {
        List<Question> quests = testCreator.addWithoutDuplicates(fakeList);
        List<Question> tmp = Lists.newArrayList(quests);
        for (Question q : quests) {
            tmp.remove(q);
            Assert.assertFalse(tmp.contains(q));
        }
        Assert.assertEquals(0, tmp.size());
    }
    
    @Test
    public void shouldReturnGeneratedTestWhendbCointainsExaclyTenQuests() {
        fakeList.remove(0);
        List<Question> quests = testCreator.addWithoutDuplicates(fakeList);
        Assert.assertEquals(10, quests.size());
    }
    
    public void shouldEvalueteTestDifficult() {
        // given

        // when

        // then
        // assertFalse(1 == 1);
    }

    public void shouldEvaluatePointsForUser() {
        // given

        // when

        // then
        // assertFalse(1 == 1);
    }

    public void shouldReturnTrueWhenTestsDifficultIsSimilar() {
        // given

        // when

        // then
        // assertFalse(1 == 1);
    }

    public void shouldReturnTrueWhenAllQuestsInTestAreDifferent() {
        // // given
        // when(questService.getAllQuestions()).thenReturn(fakeList);
        // int questionsAmount = 5;
        // // when
        // List<Question> questionsInTest =
        // testCreator.createTest(questionsAmount);
        // // then
        // assertThat(questionsInTest).doesNotHaveDuplicates();
    }

    public void shouldThrowException() {
        // // given
        // when(questService.getAllQuestions()).thenReturn(shortFakeList);
        // int questionsAmount = 5;
        // // when
        // List<Question> questionsInTest =
        // testCreator.createTest(questionsAmount);
        // // then
        // assertThat(questionsInTest).doesNotHaveDuplicates();
    }

}
