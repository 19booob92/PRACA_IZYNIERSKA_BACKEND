package sample.data.jpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@Entity
@Table(name = "questions")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Question implements Serializable {

    private static final long serialVersionUID = 6429316483965915569L;

    @Id
    @GeneratedValue
    private long id;

    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;

    private String content;

    private String correctAnswer;
    
    private int points;
    
    @ManyToOne
    @JoinColumn(name = "test")
    private Test test;
    
    public String getContent(){
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", content=" + content + "]";
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

    
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    
    public int getPoints() {
        return points;
    }

    
    public void setPoints(int points) {
        this.points = points;
    }

}
