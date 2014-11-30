package com.pwr.quizzer.service;

import java.util.Set;

import org.springframework.data.domain.Page;

import com.pwr.quizzer.model.Results;


public interface ResultsService {
    
    Page<Results> getAllResults(Integer pageNum);
    Set<Results> getResultsForUser(long id);
    Set<Results> getResultsForTest(long id);
    void addResult(Results result);
    String evaluateMark(int points, int max);
    
}
