package com.bespoke.drinking.service;

import java.io.IOException;
import java.util.List;

import com.bespoke.drinking.dto.NewQuestion;
import com.bespoke.drinking.model.AnsweredQuestion;
import com.bespoke.drinking.model.Question;

public interface QuestionService {

	Question addAnsweredQuestion(Integer userId, AnsweredQuestion answeredQuestion);
	
	void createNewQuestion(NewQuestion newQuestion) throws IOException;
	
	List<Question> getUnansweredCreatedQuestions(Integer userId);
}
