package sample.data.jpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.data.jpa.model.CourseGenere;
import sample.data.jpa.repository.CourseRepo;

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

}
