package com.pwr.quizzer.core;

import java.util.ArrayList;
import java.util.Collections;
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
        List<CourseGenere> courses = courseService.findAll();
        evaluateValues(courses);

        List<Question> questsForCourse = courseService.findCourse(courseGroup).getQuestions();

        if (TestController.QUEST_AMOUNT > questsForCourse.size()) {
            throw new IllegalArgumentException(String.valueOf(questsForCourse.size()));
        }

        return oven.findTestsWithSamePointsAmount(questsForCourse, courseGroup);
    }

    public static List<Question> addWithoutDuplicates(List<Question> inputList) {
        List<Question> temp = Lists.newArrayList(inputList);

        Collections.shuffle(temp);

        return temp.subList(0, 10);
    }

}
