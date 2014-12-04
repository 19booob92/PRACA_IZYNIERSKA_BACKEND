package com.pwr.quizzer.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "courseGenere")
public class CourseGenere implements Serializable {

    private static final long serialVersionUID = 6222908703058417048L;

    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "courseGenere")
    private List<Question> questions;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @JsonIgnore
    public List<Question> getQuestions() {
        return questions;
    }

    @JsonIgnore
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((questions == null) ? 0 : questions.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getName().equals(((CourseGenere) obj).getName())) {
            return true;
        }
        return false;
    }

    
    public long getId() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
    }

}
