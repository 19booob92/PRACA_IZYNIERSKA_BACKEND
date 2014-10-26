package sample.data.jpa.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sample.data.jpa.model.UserTmp;

public interface UserService {

    UserTmp findByUserName(String login);
}
