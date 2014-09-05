package sample.data.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.model.Question;
import sample.data.jpa.repository.QuestionRepo;

@Transactional
@Service
public class QuestionServiceImpl implements QuestionService {
    
    @Autowired
    private QuestionRepo questionRepo;
    
    @Override
    public void addQuestion(Question question) {
        questionRepo.save(question);
    }

    @Override
    public Question getOneQuestion(Long id) {
        return questionRepo.findOne(id);
    }
    
    @Override
    public void deleteQuestion(Long id) {
        questionRepo.delete(id);
    }

    @Override
    public List<Question> getAllQuestions() {
        return (List<Question>) questionRepo.findAll();
    }

}
