package com.pwr.quizzer.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.pwr.quizzer.service.TestService;


public class IdGenerator {
    
    @Autowired
    private TestService testService;
    
    static long testId = 0;
    
    static public long getNextTestId() {
        
        return testId++;
    }
}
