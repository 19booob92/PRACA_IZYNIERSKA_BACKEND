package sample.data.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import sample.data.jpa.model.Mark;


public interface MarkRepo extends CrudRepository<Mark, Long> {

}

