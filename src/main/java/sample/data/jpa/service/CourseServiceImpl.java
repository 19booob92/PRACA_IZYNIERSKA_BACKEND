package sample.data.jpa.service;

import javax.transaction.Transactional;

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
    public CourseGenere getService(String name) {
        return courseRepo.findByName(name);
    }

}
