package sample.data.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import sample.data.jpa.model.CourseGenere;
import sample.data.jpa.model.Question;
import sample.data.jpa.service.CourseService;
import sample.data.jpa.service.CourseServiceImpl;
import sample.data.jpa.service.QuestionService;
import sample.data.jpa.utils.IntegrationTest;


public class QuestionsServiceTest extends IntegrationTest{

    @Autowired
    QuestionService questions;
    
    @Test
    public void shouldGetCourseWithNameAlgebra() {
        
    }
}
