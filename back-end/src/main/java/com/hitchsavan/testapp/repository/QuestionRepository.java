package com.hitchsavan.testapp.repository;

import com.hitchsavan.testapp.models.Question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    
}