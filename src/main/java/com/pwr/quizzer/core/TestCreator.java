package com.pwr.quizzer.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pwr.quizzer.model.CourseGenere;
import com.pwr.quizzer.model.Question;
import com.pwr.quizzer.model.Test;
import com.pwr.quizzer.service.CourseService;
import com.pwr.quizzer.web.TestController;

import static com.pwr.quizzer.utils.PointsAvg.*;


@Component
public class TestCreator {

    private Annealing oven = new Annealing();

    @Autowired
    private CourseService courseService;

    private static Random random;

    public TestCreator() {
        random = new Random(System.nanoTime());
    }

    public Test createTest(String courseGroup) throws IllegalArgumentException {
        List<CourseGenere> courses = courseService.findAll(); // TODO nie w tym miejscu chyba
        evaluateValues(courses); // TODO w innym komponencie

        List<Question> questsForCourse = courseService.findCourse(courseGroup).getQuestions();
        
        if (TestController.QUEST_AMOUNT > questsForCourse.size()) {
            throw new IllegalArgumentException(String.valueOf(questsForCourse.size()));
        }

        return oven.findTestsWithSamePointsAmount(questsForCourse, courseGroup);
    }

    public static List<Question> addWithoutDuplicates(List<Question> inputList) {
        Question actualItem;
        List<Question> temp = Lists.newArrayList(inputList);
        List<Question> outputList = new ArrayList<>();
        for (int i = 0; i < TestController.QUEST_AMOUNT; i++) {
            actualItem = randomQuestion(temp);

            while (outputList.contains(actualItem)) {
                actualItem = randomQuestion(temp);
            }
            temp.remove(actualItem);
            outputList.add(actualItem);
        }
        return outputList;
    }

    private static Question randomQuestion(List<Question> inputList) {
        int randomValue = random.nextInt(inputList.size() - 1);
        return inputList.get(randomValue);
    }

    public static List<Question> getRandomTest(List<Question> allQuestions) {
        List<Question> outputList = new ArrayList<Question>();

        for (int i = 0; i < TestController.QUEST_AMOUNT; i++) {
            outputList = TestCreator.addWithoutDuplicates(allQuestions);
        }
        return outputList;
    }

}
