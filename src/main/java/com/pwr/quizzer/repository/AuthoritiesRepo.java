package com.pwr.quizzer.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.pwr.quizzer.model.Authorities;


public interface AuthoritiesRepo extends CrudRepository<Authorities, String> {

    @Modifying
    @Transactional
    @Query("delete from Authorities u where u.username = ?1")
    void deleteAuthorityByUserName(String username);

}
