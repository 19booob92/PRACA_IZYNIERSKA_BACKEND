package sample.data.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import sample.data.jpa.model.UserTmp;


public interface UsersRepo extends CrudRepository<UserTmp, Long> {

    UserTmp findByLogin(String login);

}
