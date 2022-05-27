package com.bespoke.drinking.repository;

import com.bespoke.drinking.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	Question findByText(String text);
}
