package com.pwr.quizzer.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pwr.quizzer.model.Mark;
import com.pwr.quizzer.model.Results;
import com.pwr.quizzer.repository.ResultsRepo;


@Service
@Transactional
public class ResultsServiceImpl implements ResultsService {
    
    private final int ENTRIES_PER_PAGE = 5;
    
    @Autowired
    ResultsRepo resultsRepo;

    @Autowired
    MarkService service;

    @Override
    public Page<Results> getAllResults(Integer pageNum) {
        PageRequest request =
                new PageRequest(pageNum - 1, ENTRIES_PER_PAGE);
        return resultsRepo.findAll(request);
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

    
    @Override
    public String evaluateMark(int points, int maxPoints) {
        Mark mark = service.getModel(); 
        final float PERCENT = (float) (100. * ((float)points / (float)maxPoints));

        if (PERCENT < mark.getTresholdE()) {
            return Mark.NIEDOPUSZCZAJACY;
        } else if (PERCENT < mark.getTresholdD()) {
            return Mark.DOSTATECZNY;
        } else if (PERCENT < mark.getTresholdC()) {
            return Mark.DOBRY;
        } else if (PERCENT < mark.getTresholdB()) {
            return Mark.BARDZO_DOBRY;
        } else {
            return Mark.CELUJACY;
        }
    }
}
