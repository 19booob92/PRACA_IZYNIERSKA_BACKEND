package com.pwr.quizzer.dto;

import java.io.Serializable;


public class MarkDTO implements Serializable {

    private static final long serialVersionUID = -5421421909315236824L;
    
    private int tresholdA;
    private int tresholdB;
    private int tresholdC;
    private int tresholdD;
    private int tresholdE;

    public int getTresholdA() {
        return tresholdA;
    }

    public void setTresholdA(int tresholdA) {
        this.tresholdA = tresholdA;
    }

    public int getTresholdB() {
        return tresholdB;
    }

    public void setTresholdB(int tresholdB) {
        this.tresholdB = tresholdB;
    }

    public int getTresholdC() {
        return tresholdC;
    }

    public void setTresholdC(int tresholdC) {
        this.tresholdC = tresholdC;
    }

    public int getTresholdD() {
        return tresholdD;
    }

    public void setTresholdD(int tresholdD) {
        this.tresholdD = tresholdD;
    }

    public int getTresholdE() {
        return tresholdE;
    }

    public void setTresholdE(int tresholdE) {
        this.tresholdE = tresholdE;
    }
}
