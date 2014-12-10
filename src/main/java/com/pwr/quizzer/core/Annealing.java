package com.pwr.quizzer.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.util.Lists;

import com.pwr.quizzer.model.Question;
import com.pwr.quizzer.model.Test;
import com.pwr.quizzer.utils.IdGenerator;
import com.pwr.quizzer.utils.PointsAvg;
import com.pwr.quizzer.web.TestController;


public class Annealing {

    private List<Question> testToServe = new ArrayList<Question>();

    private List<Question> allQuestionsFromGroup = new ArrayList<Question>();

    private List<Question> bestSolution;
    
    private static final double E = 2.71828152;

    private Random random;

    private String courseGroup;

    private final static float MIN_TEMP = 0.05f;
    private static double ACTUAL_TEMP = 100;

    
    public Test findTestsWithSamePointsAmount(List<Question> questsFromGroup, String courseGenere) {
        this.courseGroup = courseGenere;
        allQuestionsFromGroup = questsFromGroup;
        random = new Random(System.nanoTime());
        testToServe = splitQuestionList();
        bestSolution = testToServe;
        
        
        while (ACTUAL_TEMP > MIN_TEMP) {
            List<Question> beforeSwap = Lists.newArrayList(testToServe);
            List<Question> beforeSwapOtherQuest = Lists.newArrayList(allQuestionsFromGroup);

            int bef = PointsAvg.getPointsFromTest(testToServe);

            swap();

            int aft = PointsAvg.getPointsFromTest(testToServe);

            List<Question> afterSwap = Lists.newArrayList(testToServe);

            if (PointsAvg.isCloser(afterSwap, beforeSwap, courseGenere)) {
                if (random.nextFloat() * 1.0 < probality(ACTUAL_TEMP, beforeSwap, afterSwap)) {
                    testToServe = afterSwap;
                    allQuestionsFromGroup = beforeSwapOtherQuest;
                } else {
                    testToServe = beforeSwap;
                    allQuestionsFromGroup = beforeSwapOtherQuest;
                }
            }
            else if (PointsAvg.isCloser(afterSwap, bestSolution, courseGenere)){
                bestSolution = afterSwap;
            }
            
            ACTUAL_TEMP = cooling(ACTUAL_TEMP);
        }
        Test test = new Test();
        test.setId(IdGenerator.getNextTestId());
        test.setQuestions(bestSolution);
        
        return test;
    }

    private double probality(double temp, List<Question> beforeList, List<Question> afterList) {
        int beforePoints = PointsAvg.getPointsFromTest(beforeList);
        int afterPoints = PointsAvg.getPointsFromTest(afterList);

        return Math.pow(E, -(PointsAvg.accuracy(afterPoints, this.courseGroup) - PointsAvg.accuracy(beforePoints, this.courseGroup))
                / (ACTUAL_TEMP));
    }

    private double cooling(double temp) {
        return temp * 0.97;
    }

    private List<Question> splitQuestionList() {
        if (TestController.QUEST_AMOUNT > allQuestionsFromGroup.size()) {
            throw new IllegalArgumentException(String.valueOf(allQuestionsFromGroup.size()));
        }

        List<Question> outputList = new ArrayList<Question>();

        outputList = TestCreator.addWithoutDuplicates(allQuestionsFromGroup);

        allQuestionsFromGroup.removeAll(outputList); // deleted questions unused
                                                     // in first test

        return outputList;
    }

    private void swap() {

        int range = 10;// (testToServe.size() - 1) > 0 ? testToServe.size(): 1;
        int indexToSwap = random.nextInt(range);
        range = (allQuestionsFromGroup.size() - 1) > 0 ? allQuestionsFromGroup.size() : 1;
        int indexToSwapWhith = random.nextInt(range);

        Question questToSwap = testToServe.remove(indexToSwap);
        Question questToSwapWhith = allQuestionsFromGroup.remove(indexToSwapWhith);

        allQuestionsFromGroup.add(questToSwap);
        testToServe.add(questToSwapWhith);
    }
}
