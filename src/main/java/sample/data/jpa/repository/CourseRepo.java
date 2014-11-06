package sample.data.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import sample.data.jpa.model.CourseGenere;


public interface CourseRepo extends CrudRepository<CourseGenere, Long> {
    CourseGenere findByName(String name);
}
