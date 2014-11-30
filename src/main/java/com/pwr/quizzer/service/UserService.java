package com.pwr.quizzer.service;

import com.pwr.quizzer.model.UserTmp;

public interface UserService {

    UserTmp findByUserName(String login);

}
