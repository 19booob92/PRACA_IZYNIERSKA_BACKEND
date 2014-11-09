package sample.data.jpa.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.data.dto.EditQuestionDTO;
import sample.data.jpa.model.CourseGenere;
import sample.data.jpa.model.Question;
import sample.data.jpa.service.CourseService;
import sample.data.jpa.service.QuestionService;

@Component
public class QuestionMapper {
    
    @Autowired
    private QuestionService questService;
    
    @Autowired
    private CourseService courseService;
    
    public Question convert(EditQuestionDTO quest){

        CourseGenere course = courseService.findCourse(quest.getCourseGenere());
        Question questionModel = questService.getOneQuestion(quest.getId());
        
        questionModel.setAnswerA(quest.getAnswerA());
        questionModel.setAnswerB(quest.getAnswerB());
        questionModel.setAnswerC(quest.getAnswerC());
        questionModel.setAnswerD(quest.getAnswerD());
        questionModel.setContent(quest.getContent());
        questionModel.setCorrectAnswer(quest.getCorrectAnswer());
        questionModel.setCourseGenere(course);
        return questionModel;
    }
}
