package com.pwr.quizzer.model;

import java.io.Serializable;


public class Users implements Serializable {

    private static final long serialVersionUID = 8132520270490715635L;

    private String userName;
    private String password;
    private Boolean enabled;
    private String auth;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    public String getAuth() {
        return auth;
    }


    public void setAuth(String auth) {
        this.auth = auth;
    }


}
