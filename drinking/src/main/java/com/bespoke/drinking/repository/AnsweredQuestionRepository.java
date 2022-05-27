package com.bespoke.drinking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bespoke.drinking.model.AnsweredQuestion;

@Repository
public interface AnsweredQuestionRepository extends JpaRepository<AnsweredQuestion, Integer>{

}
