package com.pwr.quizzer.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.pwr.quizzer.dto.AnswerDTO;
import com.pwr.quizzer.model.Test;
import com.pwr.quizzer.repository.TestRepo;

@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepo testRepo;

    @Override
    public List<Test> getAllTests() {
        return Lists.newArrayList(testRepo.findAll());
    }

    @Override
    public List<Test> getTestsByCourseGenere(String courseGenere) {
        return testRepo.findByCourseGenere(courseGenere);
    }

    @Override
    public void saveTest(Test test) {
        testRepo.save(test);
    }

    @Override
    public void completeTestData(int points, AnswerDTO questions) {

        Test uncompleatedTest = testRepo.findOne(questions.getTestId());
        Gson gson = new Gson();
        uncompleatedTest.setGainedPoints(points);
        uncompleatedTest.setUsersAnswer(gson.toJson(questions.getQuestions()));
        
        long actualTime = System.currentTimeMillis();
        Date date = new Date(actualTime);
        
        uncompleatedTest.setFinishTime(date);
        
        testRepo.save(uncompleatedTest);
    }

    @Override
    public Test getTestById(long id) {
        return testRepo.findOne(id);
    }

    @Override
    public Test getTestsByUsername(String username, String courseGenere) {
        List<Test> tests = Lists.newArrayList(testRepo.findTestByUser(username));
        for (Test test : tests) {
            if (test != null && test.getCourseGenere() != null && test.getCourseGenere().equals(courseGenere)) {
                return test; 
            }
        }
        return null;
    }

}
