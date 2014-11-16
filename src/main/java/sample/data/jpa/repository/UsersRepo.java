package sample.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.model.UserTmp;


public interface UsersRepo extends JpaRepository<UserTmp, Long> {

    UserTmp findByUsername(String login);
    
    @Modifying
    @Transactional
    @Query("delete from UserTmp u where u.username = ?1")
    void deleteUsersByUsername(String username);
    
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update UserTmp u set u.password = ?2, u.able = ?3, u.enabled = ?4 where u.username = ?1")
    void updateUser(String username, String password, String able, boolean enabled);
    
}
