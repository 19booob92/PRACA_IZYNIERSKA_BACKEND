package sample.data.jpa.controllers;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import sample.data.core.TestBase;

import com.pwr.quizzer.core.Annealing;
import com.pwr.quizzer.model.Question;
import com.pwr.quizzer.model.Test;


@RunWith(MockitoJUnitRunner.class)
public class AnnealingTest extends TestBase{

    private Annealing classUnderTest = new Annealing();
    
    @Before
    public void init() {
        createQuestions();
    }
    
    @org.junit.Test
    public void shouldGenereateTestWhenDBContainsExacly10Quests() {

        Test test = classUnderTest.findTestsWithSamePointsAmount(fakeList, "Algebra");

        List<Question> quests = test.getQuestions();
        
        List<Question> tmp = Lists.newArrayList(quests);
        
        for (Question q : quests) {
            tmp.remove(q);
            Assert.assertFalse(tmp.contains(q));
        }
        Assert.assertEquals(0, tmp.size());
    }
}
