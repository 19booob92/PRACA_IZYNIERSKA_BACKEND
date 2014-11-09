package sample.data.jpa.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.data.jpa.model.CourseGenere;
import sample.data.jpa.model.Question;
import sample.data.jpa.service.CourseService;
import sample.data.jpa.service.QuestionService;

@Component
public class TestCreator {

    @Autowired
    private CourseService courseService;

    private Random random;

    private List<Question> listFromDataBase;

    public TestCreator() {
        random = new Random(); // FIXME jakieś zeiarno z dobrym mieszaniem
    }

    public List<Question> createTest(int questionsAmout, String name) throws IllegalArgumentException {
        CourseGenere course = courseService.findCourse(name);
        listFromDataBase = course.getQuestions();
        
        if (questionsAmout > listFromDataBase.size()) {
            throw new IllegalArgumentException(String.valueOf(listFromDataBase.size()));
        }
        
        List<Question> outputList = new ArrayList<Question>();
        
        for (int i = 0; i < questionsAmout; i++) {
            addWithoutDuplicates(outputList);
        }
        return outputList;
    }

    private void addWithoutDuplicates(List<Question> outputList) {
        Question actualItem = randomQuestion();

        while (outputList.contains(actualItem)) {
            actualItem = randomQuestion();
        }
        outputList.add(actualItem);
    }

    private Question randomQuestion() {
        List<Question> listCopy = Lists.newArrayList(listFromDataBase);
        int randomValue = random.nextInt(listCopy.size()-1);
        listCopy.remove(randomValue);
        return listFromDataBase.get(randomValue);
    }

}
