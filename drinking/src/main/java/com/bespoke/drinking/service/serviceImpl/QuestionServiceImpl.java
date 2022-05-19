package com.bespoke.drinking.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bespoke.drinking.model.Question;
import com.bespoke.drinking.model.User;
import com.bespoke.drinking.repository.UserRepository;
import com.bespoke.drinking.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	UserRepository userRepository;

	@Override
	public void addAnsweredQuestion(int userId, Question question) {
		User user = userRepository.getById(userId);
		user.addAnsweredQuestion(question);
		userRepository.save(user);
	}
	
}
