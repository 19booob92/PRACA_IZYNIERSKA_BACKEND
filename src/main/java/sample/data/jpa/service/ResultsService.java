package sample.data.jpa.service;

import java.util.List;
import java.util.Set;

import sample.data.jpa.model.Results;


public interface ResultsService {
    
    List<Results> getAllResults();
    Set<Results> getResultsForUser(long id);
    Set<Results> getResultsForTest(long id);
    void addResult(Results result);
    String evaluateMark(int points, int max);
    
}
