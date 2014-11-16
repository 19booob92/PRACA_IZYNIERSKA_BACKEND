package sample.data.jpa.utils;

import org.springframework.beans.factory.annotation.Autowired;

import sample.data.jpa.service.TestService;


public class IdGenerator {
    
    @Autowired
    private TestService testService;
    
    static long testId = 0;
    
    static public long getNextTestId() {
        
        return testId++;
    }
}
