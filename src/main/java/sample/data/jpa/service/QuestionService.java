package sample.data.jpa.service;

import sample.data.jpa.model.Question;


public interface QuestionService {
    
    void addQuestion(Question quest);
    Question getOneQuestion(Long id);
    void deleteQuestion(Long id);
}
