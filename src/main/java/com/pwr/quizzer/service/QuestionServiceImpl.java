package com.pwr.quizzer.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.activemq.filter.function.splitFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pwr.quizzer.dto.EditQuestionDTO;
import com.pwr.quizzer.dto.QuestionDTO;
import com.pwr.quizzer.mappers.QuestionMapper;
import com.pwr.quizzer.model.CourseGenere;
import com.pwr.quizzer.model.Question;
import com.pwr.quizzer.repository.QuestionRepo;


@Transactional
@Service
public class QuestionServiceImpl implements QuestionService {

    private static final int ENTRIES_PER_PAGE = 5;

    private final static int ANY_QUEST = 0;

    @Autowired
    private CourseService courseService;

    @Autowired
    private QuestionRepo questionRepo;

    @Autowired
    private QuestionMapper questMapper;

    @Override
    public Question getOneQuestion(Long id) {
        return questionRepo.findOne(id);
    }

    @Override
    public void deleteQuestion(int id) {
        questionRepo.delete((long) id);
    }

    @Override
    public Page<Question> getAllQuestions(String courseName, Integer page) {
        PageRequest request =
                new PageRequest(page - 1, ENTRIES_PER_PAGE);

        Page<Question> quests = questionRepo.findByCourseGenereName(courseName, request);
        return quests;
    }

    @Override
    public void addQuestion(EditQuestionDTO quest) {
        CourseGenere course = courseService.findCourse(quest.getCourseGenere());
        Question questionModel = new Question();
        questionModel.setAnswerA(quest.getAnswerA());
        questionModel.setAnswerB(quest.getAnswerB());
        questionModel.setAnswerC(quest.getAnswerC());
        questionModel.setAnswerD(quest.getAnswerD());
        questionModel.setContent(quest.getContent());
        questionModel.setCorrectAnswer(quest.getCorrectAnswer());
        questionModel.setCourseGenere(course);
        questionRepo.save(questionModel);
    }

    @Override
    public void editQuestion(EditQuestionDTO quest) {
        Question question = questMapper.EditQuestionDTO2Question(quest);
        questionRepo.save(question);
    }

    @Override
    public String recognizeCourseGroup(List<QuestionDTO> quests) {
        Long questDtoId = (long) quests.get(ANY_QUEST).getId();
        Question quest = getOneQuestion(questDtoId);
        return quest.getCourseGenere().getName();
    }

}
