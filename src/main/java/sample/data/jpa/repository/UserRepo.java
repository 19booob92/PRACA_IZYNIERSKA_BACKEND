package sample.data.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import sample.data.jpa.model.User;


public interface UserRepo extends CrudRepository<User, Long> {

    User findByLogin(String login);

}
