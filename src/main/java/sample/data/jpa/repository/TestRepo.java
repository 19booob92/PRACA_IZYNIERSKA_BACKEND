package sample.data.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sample.data.jpa.model.Test;


public interface TestRepo extends CrudRepository<Test, Long> {
    
    List<Test> findByCourseGenere(String courseGenere);
}

