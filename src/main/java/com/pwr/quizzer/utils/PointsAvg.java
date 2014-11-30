package com.pwr.quizzer.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pwr.quizzer.model.CourseGenere;
import com.pwr.quizzer.model.Question;


public class PointsAvg {

    public static Map<String, Float> avgOfPointsAmount = new HashMap<>();

    private static final int NUMBER_OF_PROBES = 5;

    public static void evaluateValues(List<CourseGenere> courses) {
        for (CourseGenere course : courses) {
            avgOfPointsAmount.put(course.getName(), evaluateAvg(course));
        }
    }

    private static Float evaluateAvg(CourseGenere course) {
        int pointsSum = 0;
        for (int i = 0; i < NUMBER_OF_PROBES; i++) {
            pointsSum += getPointsFromTest(course.getQuestions());
        }
        return new Float(pointsSum / NUMBER_OF_PROBES);
    }

    public static int getPointsFromTest(List<Question> questions) {
        int pointsSum = 0;


        for (Question quest : questions) {
            pointsSum += quest.getPoints();
        }
        return pointsSum;
    }

    public static boolean isCloser(List<Question> before, List<Question> after, String courseGenere) {
        int beforePoints = getPointsFromTest(before);
        int afterPoints = getPointsFromTest(after);
        if (accuracy(afterPoints, courseGenere) < accuracy(beforePoints, courseGenere)) {
            return true;
        }
        return false;
    }

    public static float accuracy(float value, String courseGenere) {
        return Math.abs(PointsAvg.avgOfPointsAmount.get(courseGenere) - value);
    }

}
