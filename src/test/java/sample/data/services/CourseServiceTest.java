package sample.data.services;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pwr.quizzer.service.ResultsService;

import sample.data.jpa.utils.IntegrationTest;


public class CourseServiceTest extends IntegrationTest{

    @Autowired
    ResultsService resultService;
    
    @Test
    public void shouldReturnTwoRows() {
    }
}
