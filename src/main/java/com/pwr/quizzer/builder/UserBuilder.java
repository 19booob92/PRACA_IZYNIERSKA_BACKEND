package com.pwr.quizzer.builder;
//package sample.data.jpa.builder;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
//
//import org.apache.commons.lang3.builder.Builder;
//
//import sample.data.jpa.model.User;
//import sample.data.jpa.model.UserRole;
//
//
//public class UserBuilder implements Builder<User>{
//
//    private UserBuilder() {
//    }
//    
//    private int indexNo;
//
//    private String name;
//
//    private String surname;
//
//    private String address;
//
//    private String semester;
//
//    private Date dateOfBirth;
//
//    private String password;
//
//    private boolean enabled = true;
//
//    private String login;
//
//    private Set<UserRole> userRole = new HashSet<UserRole>(0);
//    
//    public UserBuilder user() {
//        return new UserBuilder();
//    }
//    
//    @Override
//    public User build() {
//        return User();
//    }
//
//}
