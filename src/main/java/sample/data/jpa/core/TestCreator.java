package sample.data.jpa.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sample.data.jpa.model.Question;
import sample.data.jpa.service.QuestionService;

@Component
public class TestCreator {

    @Autowired
    public QuestionService questService;

    private Random random;

    private List<Question> listFromDataBase;

    public TestCreator() {
        random = new Random(); // FIXME jakieś zeiarno z dobrym mieszaniem
    }

    public List<Question> createTest(int questionsAmout) throws IllegalArgumentException {
        listFromDataBase = questService.getAllQuestions();
        
        if (questionsAmout > listFromDataBase.size()) {
            throw new IllegalArgumentException();
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
        int randomValue = random.nextInt(listFromDataBase.size());
        return listFromDataBase.get(randomValue);
    }

}
