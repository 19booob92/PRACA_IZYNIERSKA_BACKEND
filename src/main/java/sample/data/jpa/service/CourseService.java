package sample.data.jpa.service;

import java.util.List;

import sample.data.jpa.model.CourseGenere;


public interface CourseService {

    CourseGenere findCourse(String name);
    List<CourseGenere> findAll();
}
