package com.bespoke.drinking.repository;

import java.util.List;

import com.bespoke.drinking.model.Answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	@Query("select a from Answer a where a.question = ?1")
	List<Answer> findByQuestion(String question);
}
