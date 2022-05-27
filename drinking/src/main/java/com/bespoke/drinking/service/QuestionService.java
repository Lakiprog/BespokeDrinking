package com.bespoke.drinking.service;

import com.bespoke.drinking.model.AnsweredQuestion;
import com.bespoke.drinking.model.Question;

public interface QuestionService {

	Question addAnsweredQuestion(Integer userId, AnsweredQuestion answeredQuestion);
}
