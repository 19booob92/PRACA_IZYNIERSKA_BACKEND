package sample.data.jpa.service;

import java.util.List;

import sample.data.dto.EditQuestionDTO;
import sample.data.dto.QuestionDTO;
import sample.data.jpa.model.Question;


public interface QuestionService {
    
    void addQuestion(EditQuestionDTO quest);
    void editQuestion(EditQuestionDTO quest);
    Question getOneQuestion(Long id);
    void deleteQuestion(int id);
    List<Question> getAllQuestions();
    String recognizeCourseGroup(List<QuestionDTO> quest);
}
