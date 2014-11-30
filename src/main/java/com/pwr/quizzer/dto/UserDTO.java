package com.pwr.quizzer.dto;


public class UserDTO {

    private String username;

    private boolean enabled = true;

    private String able = "";

    private String role = "";


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public boolean isEnabled() {
        return enabled;
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public String getAble() {
        return able;
    }


    public void setAble(String able) {
        this.able = able;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }

}
