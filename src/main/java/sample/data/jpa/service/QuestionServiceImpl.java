package sample.data.jpa.service;

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
    
    public QuestionRepo getQuestionRepo() {
        return questionRepo;
    }

    public void setQuestionRepo(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

}
