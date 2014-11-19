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
    
    public Question EditQuestionDTO2Question(EditQuestionDTO quest){

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

    public EditQuestionDTO Question2EditQuestionDTO(Question quest){

        EditQuestionDTO questDto = new EditQuestionDTO();
        
        questDto.setAnswerA(quest.getAnswerA());
        questDto.setAnswerB(quest.getAnswerB());
        questDto.setAnswerC(quest.getAnswerC());
        questDto.setAnswerD(quest.getAnswerD());
        questDto.setContent(quest.getContent());
        questDto.setCorrectAnswer(quest.getCorrectAnswer());
        questDto.setPoints(quest.getPoints());
        questDto.setCourseGenere(quest.getCourseGenere().getName());
        questDto.setId(quest.getId());
        return questDto;
    }
}
