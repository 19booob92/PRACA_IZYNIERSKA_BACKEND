package sample.data.jpa.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sample.data.jpa.model.User;

public interface UserService {

    User findByUserName(String login);
}
