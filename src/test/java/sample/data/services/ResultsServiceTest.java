package sample.data.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import sample.data.jpa.model.CourseGenere;
import sample.data.jpa.service.CourseService;
import sample.data.jpa.service.CourseServiceImpl;
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
