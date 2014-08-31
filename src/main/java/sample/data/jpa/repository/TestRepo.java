package sample.data.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import sample.data.jpa.model.Test;


public interface TestRepo extends CrudRepository<Test, Long> {

}

