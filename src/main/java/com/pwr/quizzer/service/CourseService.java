package com.pwr.quizzer.service;

import java.util.List;

import com.pwr.quizzer.model.CourseGenere;


public interface CourseService {

    CourseGenere findCourse(String name);
    List<CourseGenere> findAll();
    void save(CourseGenere course);
}
