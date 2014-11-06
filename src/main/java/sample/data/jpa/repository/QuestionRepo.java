package sample.data.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import sample.data.jpa.model.Question;


public interface QuestionRepo extends CrudRepository<Question, Long> {
}

