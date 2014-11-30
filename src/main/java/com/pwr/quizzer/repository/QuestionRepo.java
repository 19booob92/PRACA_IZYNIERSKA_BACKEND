package com.pwr.quizzer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pwr.quizzer.model.CourseGenere;
import com.pwr.quizzer.model.Question;


public interface QuestionRepo extends CrudRepository<Question, Long> {
    
}

