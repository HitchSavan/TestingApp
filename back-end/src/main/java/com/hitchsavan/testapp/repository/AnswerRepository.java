package com.hitchsavan.testapp.repository;

import com.hitchsavan.testapp.models.Answer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
