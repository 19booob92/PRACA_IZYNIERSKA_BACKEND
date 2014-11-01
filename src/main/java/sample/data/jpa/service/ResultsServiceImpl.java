package sample.data.jpa.service;

import java.util.List;
import java.util.Set;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.data.jpa.model.Results;
import sample.data.jpa.repository.ResultsRepo;

@Service
public class ResultsServiceImpl implements ResultsService {
    
    @Autowired
    ResultsRepo resultsRepo;
    
    @Override
    public List<Results> getAllResults() {
        return Lists.newArrayList(resultsRepo.findAll());
    }

    @Override
    public Set<Results> getResultsForUser(long id) {
        return resultsRepo.findByStudentId(id);
    }

    @Override
    public Set<Results> getResultsForTest(long id) {
        return resultsRepo.findByTestId(id);
    }

    @Override
    public void addResult(Results result) {
        resultsRepo.save(result);
    }

}
