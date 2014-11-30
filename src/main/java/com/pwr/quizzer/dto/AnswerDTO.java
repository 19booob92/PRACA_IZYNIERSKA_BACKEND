package com.pwr.quizzer.dto;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AnswerDTO implements Serializable{
    
    private static final long serialVersionUID = 7620918360970193924L;

    private ArrayList<QuestionDTO> questions;
    private long testId;
    
    public ArrayList<QuestionDTO> getQuestions() {
        return questions;
    }
    
    public void setQuestions(ArrayList<QuestionDTO> questions) {
        this.questions = questions;
    }
    
    public long getTestId() {
        return testId;
    }
    
    public void setTestId(long testId) {
        this.testId = testId;
    }
}
