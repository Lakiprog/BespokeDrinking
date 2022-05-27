package com.bespoke.drinking.service.serviceImpl;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.bespoke.drinking.exception.UserNotFoundException;
import com.bespoke.drinking.model.AnsweredQuestion;
import com.bespoke.drinking.model.Preference;
import com.bespoke.drinking.model.Question;
import com.bespoke.drinking.model.User;
import com.bespoke.drinking.repository.AnsweredQuestionRepository;
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
	private AnsweredQuestionRepository answeredQuestionRepository;

	@Override
	public Question addAnsweredQuestion(Integer userId, AnsweredQuestion answeredQuestion) {
		Optional<User> exists = userRepository.findById(userId);
		if (!exists.isPresent()) {
			throw new UserNotFoundException(userId);
		}
		answeredQuestion = answeredQuestionRepository.save(answeredQuestion);
		User user = exists.get();
		user.addAnsweredQuestion(answeredQuestion);
		if ((user.getAnsweredQuestions().size() == 1) && (user.getPreference() == null)) {
			Preference p = new Preference();
			p.setUser(user);
			p = preferenceRepository.save(p);
			user.setPreference(p);
		}
		KieSession kieSession = kieContainer.newKieSession("questions");
		
		kieSession.insert(user);
		kieSession.fireAllRules();
		String nextQuestionText = (String) kieSession.getGlobal("nextQuestion");
		Question next = questionRepository.findByText(nextQuestionText);
		
		userRepository.save(user);
		return next;
	}
}
