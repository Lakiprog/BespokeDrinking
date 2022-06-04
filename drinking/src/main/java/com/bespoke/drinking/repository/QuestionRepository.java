package com.bespoke.drinking.repository;

import com.bespoke.drinking.model.Question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

	Question findByText(String text);
	
	@Query("select q from Question q where q.created = true")
	List<Question> getCreatedQuestions();
}
