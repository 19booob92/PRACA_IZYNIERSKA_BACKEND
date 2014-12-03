package com.pwr.quizzer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pwr.quizzer.model.Question;


public interface QuestionRepo extends JpaRepository<Question, Long> {
    Page<Question> findByCourseGenereName(String courseGenere, Pageable pageable);
}

