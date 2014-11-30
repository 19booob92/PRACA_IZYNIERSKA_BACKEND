package com.pwr.quizzer.repository;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pwr.quizzer.model.Results;


public interface ResultsRepo extends JpaRepository<Results, Long>{

    Set<Results> findByTestId(long id);
    Set<Results> findByStudentId(long id);
}
