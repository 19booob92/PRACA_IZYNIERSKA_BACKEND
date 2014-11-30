package com.pwr.quizzer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pwr.quizzer.model.Test;


public interface TestRepo extends CrudRepository<Test, Long> {
    
    List<Test> findByCourseGenere(String courseGenere);
}

