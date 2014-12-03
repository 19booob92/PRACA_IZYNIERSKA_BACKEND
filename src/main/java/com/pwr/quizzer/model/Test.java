package com.pwr.quizzer.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "test")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Test implements Serializable {

    private static final long serialVersionUID = 6429316483912915569L;

    @Id
    private long id;

    private String user;

    private int gainedPoints;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "questsInTest", joinColumns = {
            @JoinColumn(name = "testId") },
            inverseJoinColumns = { @JoinColumn(name = "questId") })
    private List<Question> questions;

    private String usersAnswer;

    private String courseGenere;

    private Date finishTime;

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getUser() {
        return user;
    }


    public void setUser(String user) {
        this.user = user;
    }


    public int getGainedPoints() {
        return gainedPoints;
    }


    public void setGainedPoints(int gainedPoints) {
        this.gainedPoints = gainedPoints;
    }


    public List<Question> getQuestions() {
        return questions;
    }


    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    public String getUsersAnswer() {
        return usersAnswer;
    }


    public void setUsersAnswer(String usersAnswer) {
        this.usersAnswer = usersAnswer;
    }


    public String getCourseGenere() {
        return courseGenere;
    }


    public void setCourseGenere(String courseGenere) {
        this.courseGenere = courseGenere;
    }


    public Date getFinishTime() {
        return finishTime;
    }


    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }


}
