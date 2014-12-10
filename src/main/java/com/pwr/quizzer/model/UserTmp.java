package com.pwr.quizzer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.assertj.core.util.Strings;

@Entity
@Table(name = "users")
public class UserTmp implements Serializable {

    private static final long serialVersionUID = 6429316483965915578L;

    @Id
    private String username;

    private String password;
    
    private Integer indexNo;
    
    private boolean enabled = true;

    private String able = ",";

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
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
    
    public void setAble(String courseGroup) {
        if (Strings.isNullOrEmpty(this.able) || this.able.equals(",")) {
            this.able = courseGroup;
        }
        this.able += courseGroup;
        this.able += ",";
    }

    public Integer getIndexNo() {
        return indexNo;
    }
    
    public void setIndexNo(Integer indexNo) {
        this.indexNo = indexNo;
    }

}