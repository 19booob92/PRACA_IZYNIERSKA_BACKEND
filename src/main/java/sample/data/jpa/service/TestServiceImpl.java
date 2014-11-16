package sample.data.jpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import sample.data.dto.AnswerDTO;
import sample.data.jpa.model.Test;
import sample.data.jpa.repository.TestRepo;


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
    public void completeTestData(String courseGroup, int points, String user, AnswerDTO questions) {

        Test uncompleatedTest = testRepo.findOne(questions.getTestId());
        Gson gson = new Gson();
        uncompleatedTest.setCourseGenere(courseGroup);
        uncompleatedTest.setGainedPoints(points);
        uncompleatedTest.setUser(user);
        uncompleatedTest.setUsersAnswer(gson.toJson(questions.getQuestions()));

        testRepo.save(uncompleatedTest);

    }

}
