package sample.data.jpa.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.data.jpa.model.Mark;
import sample.data.jpa.model.Results;
import sample.data.jpa.repository.MarkRepo;
import sample.data.jpa.repository.ResultsRepo;


@Service
@Transactional
public class ResultsServiceImpl implements ResultsService {

    @Autowired
    ResultsRepo resultsRepo;

    @Autowired
    MarkService service;

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

    
    @Override
    public String evaluateMark(int points, int maxPoints) {
        Mark mark = service.getModel(); 
        final int PERCENT = 100* (points / maxPoints);

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
