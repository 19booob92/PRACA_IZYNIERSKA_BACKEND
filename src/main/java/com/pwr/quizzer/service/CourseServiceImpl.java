package com.pwr.quizzer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwr.quizzer.model.CourseGenere;
import com.pwr.quizzer.repository.CourseRepo;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;
    
    @Override
    public CourseGenere findCourse(String name) {
        return courseRepo.findByName(name);
    }

    @Override
    public List<CourseGenere> findAll() {
        return Lists.newArrayList(courseRepo.findAll());
    }

    @Override
    public void save(CourseGenere course) {
        courseRepo.save(course);
    }

}
