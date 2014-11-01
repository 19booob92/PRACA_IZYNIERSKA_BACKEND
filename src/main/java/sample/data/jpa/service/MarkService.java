package sample.data.jpa.service;

import sample.data.jpa.model.Mark;


public interface MarkService {

    void updateMark(int tresholdA, int tresholdB, int tresholdC, int tresholdD, int tresholdE);
    Mark getModel();
}
