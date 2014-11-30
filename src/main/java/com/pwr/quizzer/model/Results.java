package com.pwr.quizzer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Results")
public class Results implements Serializable{

    private static final long serialVersionUID = -1012871291201965484L;

    @Id
    @GeneratedValue
    private long id;
    
    private long testId;
    
    private String studentId;

    private long points;

    private long maxPoints;

    private String mark;

    private Date date;
    
    public long getTestId() {
        return testId;
    }

    
    public void setTestId(long testId) {
        this.testId = testId;
    }

    
    public long getPoints() {
        return points;
    }

    
    public void setPoints(long points) {
        this.points = points;
    }
    
    public String getStudentId() {
        return studentId;
    }


    
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    
    public long getMaxPoints() {
        return maxPoints;
    }


    
    public void setMaxPoints(long maxPoints) {
        this.maxPoints = maxPoints;
    }


    
    public String getMark() {
        return mark;
    }


    
    public void setMark(String mark) {
        this.mark = mark;
    }


    
    public long getId() {
        return id;
    }


    
    public void setId(long id) {
        this.id = id;
    }


    
    public Date getDate() {
        return date;
    }


    
    public void setDate(Date date) {
        this.date = date;
    }

    
}
