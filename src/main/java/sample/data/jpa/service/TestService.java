package sample.data.jpa.service;

import java.util.List;

import sample.data.dto.AnswerDTO;
import sample.data.jpa.model.Test;


public interface TestService {

    List<Test> getAllTests();
    
    List<Test> getTestsByCourseGenere(String courseGenere);
    
    void saveTest(Test test);

    void completeTestData(String courseGroup, int points, String user, AnswerDTO questions);
}
