package com.pwr.quizzer.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;



public class EditQuestionDTO {
    private long id;

    @NotEmpty
    @NotNull
    private String answerA = "";
    @NotEmpty
    @NotNull
    private String answerB= "";
    @NotEmpty
    @NotNull
    private String answerC= "";
    @NotEmpty
    @NotNull
    private String answerD= "";
    
    private String courseGenere= "Algebra";

    @NotEmpty
    @NotNull
    private String content= "";

    @NotEmpty
    @NotNull
    private String correctAnswer= "";
    
    @NotNull
    @Range(min=1, max=8)
    private Integer points = 0;

    
    public long getId() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
    }

    
    public String getAnswerA() {
        return answerA;
    }

    
    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    
    public String getAnswerB() {
        return answerB;
    }

    
    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    
    public String getAnswerC() {
        return answerC;
    }

    
    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    
    public String getAnswerD() {
        return answerD;
    }

    
    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    
    public String getCourseGenere() {
        return courseGenere;
    }

    
    public void setCourseGenere(String courseGenere) {
        this.courseGenere = courseGenere;
    }

    
    public String getContent() {
        return content;
    }

    
    public void setContent(String content) {
        this.content = content;
    }

    
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    
    public Integer getPoints() {
        return points;
    }

    
    public void setPoints(Integer points) {
        this.points = points;
    }
}
