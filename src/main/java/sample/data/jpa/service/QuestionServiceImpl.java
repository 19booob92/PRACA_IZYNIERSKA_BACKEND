package sample.data.jpa.service;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.data.dto.EditQuestionDTO;
import sample.data.dto.QuestionDTO;
import sample.data.jpa.mappers.QuestionMapper;
import sample.data.jpa.model.CourseGenere;
import sample.data.jpa.model.Question;
import sample.data.jpa.repository.QuestionRepo;


@Transactional
@Service
public class QuestionServiceImpl implements QuestionService {

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
    public List<Question> getAllQuestions() {
        return Lists.newArrayList(questionRepo.findAll());
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
