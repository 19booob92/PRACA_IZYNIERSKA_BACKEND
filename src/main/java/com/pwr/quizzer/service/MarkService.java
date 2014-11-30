package com.pwr.quizzer.service;

import com.pwr.quizzer.model.Mark;


public interface MarkService {

    void updateMark(int tresholdA, int tresholdB, int tresholdC, int tresholdD, int tresholdE);
    Mark getModel();
}
