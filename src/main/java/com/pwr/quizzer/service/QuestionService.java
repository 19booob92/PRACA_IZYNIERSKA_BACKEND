package com.pwr.quizzer.service;

import java.util.List;

import com.pwr.quizzer.dto.EditQuestionDTO;
import com.pwr.quizzer.dto.QuestionDTO;
import com.pwr.quizzer.model.Question;


public interface QuestionService {
    
    void addQuestion(EditQuestionDTO quest);
    void editQuestion(EditQuestionDTO quest);
    Question getOneQuestion(Long id);
    void deleteQuestion(int id);
    List<Question> getAllQuestions();
    String recognizeCourseGroup(List<QuestionDTO> quest);
}
