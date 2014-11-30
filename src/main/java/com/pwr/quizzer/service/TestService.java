package com.pwr.quizzer.service;

import java.util.List;

import com.pwr.quizzer.dto.AnswerDTO;
import com.pwr.quizzer.model.Test;


public interface TestService {

    List<Test> getAllTests();
    
    List<Test> getTestsByCourseGenere(String courseGenere);
    
    void saveTest(Test test);

    void completeTestData(String courseGroup, int points, String user, AnswerDTO questions);
}
