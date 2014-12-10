package com.pwr.quizzer.service;

import javax.transaction.Transactional;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwr.quizzer.model.Mark;
import com.pwr.quizzer.repository.MarkRepo;

@Service
@Transactional
public class MarkServiceImpl implements MarkService {

    @Autowired
    MarkRepo markRepo;
    
    @Override
    public void updateMark(int tresholdA, int tresholdB, int tresholdC, int tresholdD, int tresholdE, int tresholdF, int tresholdG) {
        Mark mark = Lists.newArrayList(markRepo.findAll()).get(0);
        
        Mark markToEdit = new Mark();
        markToEdit.setId(mark.getId());
        markToEdit.setTresholdA(tresholdA);
        markToEdit.setTresholdB(tresholdB);
        markToEdit.setTresholdC(tresholdC);
        markToEdit.setTresholdD(tresholdD);
        markToEdit.setTresholdE(tresholdE);
        markToEdit.setTresholdF(tresholdF);
        markToEdit.setTresholdG(tresholdG);
        
        markRepo.save(markToEdit);
    }

    @Override
    public Mark getModel() {
        Mark mark = Lists.newArrayList(markRepo.findAll()).get(0);
        return mark;
    }

}
