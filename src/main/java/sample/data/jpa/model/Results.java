package sample.data.jpa.model;

import java.io.Serializable;

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

    
}
