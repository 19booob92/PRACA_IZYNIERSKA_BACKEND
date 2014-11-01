package sample.data.jpa.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import sample.data.jpa.model.Results;


public interface ResultsRepo extends CrudRepository<Results, Long>{

    Set<Results> findByTestId(long id);
    Set<Results> findByStudentId(long id);
}
