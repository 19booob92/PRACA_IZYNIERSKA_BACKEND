package sample.data.jpa.service;

import sample.data.jpa.model.UserTmp;

public interface UserService {

    UserTmp findByUserName(String login);

}
