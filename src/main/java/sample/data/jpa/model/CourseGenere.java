package sample.data.jpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courseGenere")
public class CourseGenere implements Serializable{
    
    private static final long serialVersionUID = 6222908703058417048L;

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "courseGenere")
    private List<Question> questions;

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public List<Question> getQuestions() {
        return questions;
    }

    
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    } 
}
