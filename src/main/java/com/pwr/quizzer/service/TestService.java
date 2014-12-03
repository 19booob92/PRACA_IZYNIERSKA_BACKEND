package com.pwr.quizzer.service;

import java.util.List;

import com.pwr.quizzer.dto.AnswerDTO;
import com.pwr.quizzer.model.Test;


public interface TestService {

    List<Test> getAllTests();
    
    List<Test> getTestsByCourseGenere(String courseGenere);
    
    Test getTestById(long id);
    
    void saveTest(Test test);

    void completeTestData(int points, AnswerDTO questions);

    Test getTestsByUsername(String username, String courseGenere);
}
