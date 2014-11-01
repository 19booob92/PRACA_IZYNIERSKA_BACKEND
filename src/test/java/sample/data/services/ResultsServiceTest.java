package sample.data.services;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import sample.data.jpa.model.Results;
import sample.data.jpa.service.ResultsService;
import sample.data.jpa.utils.IntegrationTest;


public class ResultsServiceTest extends IntegrationTest{

    @Autowired
    ResultsService resultService;
    
    @Test
    public void shouldReturnTwoRows() {
    }
}
