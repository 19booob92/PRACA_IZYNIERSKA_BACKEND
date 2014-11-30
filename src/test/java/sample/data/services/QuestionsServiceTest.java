package sample.data.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pwr.quizzer.model.CourseGenere;
import com.pwr.quizzer.model.Question;
import com.pwr.quizzer.service.CourseService;
import com.pwr.quizzer.service.CourseServiceImpl;
import com.pwr.quizzer.service.QuestionService;

import sample.data.jpa.utils.IntegrationTest;


public class QuestionsServiceTest extends IntegrationTest{

    @Autowired
    QuestionService questions;
    
    @Test
    public void shouldGetCourseWithNameAlgebra() {
        
    }
}
