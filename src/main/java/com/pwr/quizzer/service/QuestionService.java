package com.pwr.quizzer.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pwr.quizzer.dto.EditQuestionDTO;
import com.pwr.quizzer.dto.QuestionDTO;
import com.pwr.quizzer.model.Question;


public interface QuestionService {
    
    void addQuestion(EditQuestionDTO quest);
    void editQuestion(EditQuestionDTO quest);
    Question getOneQuestion(Long id);
    void deleteQuestion(int id);
    Page<Question> getAllQuestions(String courseName, Integer page);
    String recognizeCourseGroup(List<QuestionDTO> quest);
}
