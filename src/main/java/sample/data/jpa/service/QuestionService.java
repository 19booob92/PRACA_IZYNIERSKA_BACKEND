package sample.data.jpa.service;

import java.util.List;

import sample.data.jpa.model.Question;


public interface QuestionService {
    
    void addQuestion(Question quest);
    Question getOneQuestion(Long id);
    void deleteQuestion(int id);
    List<Question> getAllQuestions();
}
