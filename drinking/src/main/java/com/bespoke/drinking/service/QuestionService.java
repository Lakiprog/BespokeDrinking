package com.bespoke.drinking.service;

import com.bespoke.drinking.model.Question;

public interface QuestionService {

	void addAnsweredQuestion(int userId, Question question);
}
