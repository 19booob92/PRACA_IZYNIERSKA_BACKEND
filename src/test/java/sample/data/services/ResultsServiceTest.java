package sample.data.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pwr.quizzer.model.CourseGenere;
import com.pwr.quizzer.service.CourseService;
import com.pwr.quizzer.service.CourseServiceImpl;

import sample.data.jpa.utils.IntegrationTest;


public class ResultsServiceTest extends IntegrationTest{

    @Autowired
    CourseService courseService;
    
    @Test
    public void shouldGetCourseWithNameAlgebra() {
        
        CourseGenere course = courseService.findCourse("Algebra");
        
        assertEquals("Algebra", course.getName());
    }
    
    @Test
    public void shouldReturnAllQuestionsFromGroup() {
        CourseGenere course = courseService.findCourse("Algebra");
        
        assertEquals(12, course.getQuestions().size());
    }
}
