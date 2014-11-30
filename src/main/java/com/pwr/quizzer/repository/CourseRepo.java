package com.pwr.quizzer.repository;

import org.springframework.data.repository.CrudRepository;

import com.pwr.quizzer.model.CourseGenere;


public interface CourseRepo extends CrudRepository<CourseGenere, Long> {
    CourseGenere findByName(String name);
}
