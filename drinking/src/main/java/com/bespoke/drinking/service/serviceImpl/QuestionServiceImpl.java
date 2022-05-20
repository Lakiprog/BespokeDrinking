package com.bespoke.drinking.service.serviceImpl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.bespoke.drinking.exception.UserNotFoundException;
import com.bespoke.drinking.model.Preference;
import com.bespoke.drinking.model.Question;
import com.bespoke.drinking.model.User;
import com.bespoke.drinking.repository.AnswerRepository;
import com.bespoke.drinking.repository.PreferenceRepository;
import com.bespoke.drinking.repository.QuestionRepository;
import com.bespoke.drinking.repository.UserRepository;
import com.bespoke.drinking.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private KieContainer kieContainer;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PreferenceRepository preferenceRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public Question addAnsweredQuestion(Integer userId, Question question) {
		Optional<User> exists = userRepository.findById(userId);
		if (!exists.isPresent()) {
			throw new UserNotFoundException(userId);
		}
		question.setAnswers(answerRepository.findByQuestion(question.getText()));
		question = questionRepository.save(question);
		User user = exists.get();
		user.addAnsweredQuestion(question);
		if (user.getAnsweredQuestions().size() == 1) {
			Preference p = new Preference();
			p.setUser(user);
			p = preferenceRepository.save(p);
			user.setPreference(p);
		}
		KieSession kieSession = kieContainer.newKieSession("questions");
		
		kieSession.insert(user);
		kieSession.fireAllRules();
		Question next = (Question) kieSession.getGlobal("nextQuestion");
		
		userRepository.save(user);
		return next;
	}
}
