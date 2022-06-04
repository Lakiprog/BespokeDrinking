package com.bespoke.drinking.service.serviceImpl;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.bespoke.drinking.dto.NewQuestion;
import com.bespoke.drinking.exception.ResourceNotFoundException;
import com.bespoke.drinking.model.Answer;
import com.bespoke.drinking.model.AnsweredQuestion;
import com.bespoke.drinking.model.Preference;
import com.bespoke.drinking.model.Question;
import com.bespoke.drinking.model.User;
import com.bespoke.drinking.repository.AnswerRepository;
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
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnsweredQuestionRepository answeredQuestionRepository;

	@Override
	public Question addAnsweredQuestion(Integer userId, AnsweredQuestion answeredQuestion) {
		Optional<User> exists = userRepository.findById(userId);
		if (!exists.isPresent()) {
			throw new ResourceNotFoundException("User with this id does not exist! - " + userId);
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
		userRepository.save(user);
		if (nextQuestionText.equals("END")) {
			return new Question(nextQuestionText);
		}
		return questionRepository.findByText(nextQuestionText);
	}

	@Override
	public void createNewQuestion(NewQuestion newQuestion) throws IOException {
		newQuestion.addQuotesToText();
		File initialFile = new File("../drinking-kjar/src/main/resources/template/template.drl");
	    InputStream template = new FileInputStream(initialFile);
		List<NewQuestion> data = new ArrayList<>();
		data.add(newQuestion);
		ObjectDataCompiler converter = new ObjectDataCompiler();
		String drl = converter.compile(data, template);
		System.out.println(drl);
		
		KieHelper kieHelper = new KieHelper();
		kieHelper.addContent(drl, ResourceType.DRL);
		Results results = kieHelper.verify();
		if (results.hasMessages(Message.Level.WARNING, Message.Level.ERROR)) {
			List<Message> messages = results.getMessages(Message.Level.WARNING, Message.Level.ERROR);
			for (Message m : messages) {
				System.out.println("Error: " + m.getText());
			}
			throw new IllegalStateException("Compilation error were found!");
		}
		
		Answer a1 = new Answer();
		a1.setAnswerNumber(0);
		a1.setText(newQuestion.getFirstAnswerText());
		
		Answer a2 = new Answer();
		a2.setAnswerNumber(1);
		a2.setText(newQuestion.getSecondAnswerText());
		
		a1 = answerRepository.save(a1);
		a2 = answerRepository.save(a2);
		
		List<Answer> answers = new ArrayList<>();
		answers.add(a1);
		answers.add(a2);
		
		Question question = new Question();
		question.setText(newQuestion.getText());
		question.setAnswers(answers);
		question.setCreated(true);		
		questionRepository.save(question);
		
		FileWriter myWriter = new FileWriter("../drinking-kjar/src/main/resources/rules/" + System.currentTimeMillis() + ".drl");
        myWriter.write(drl);
        myWriter.close();
	}

	@Override
	public List<Question> getUnansweredCreatedQuestions(Integer userId) {
		Optional<User> exists =  userRepository.findById(userId);
		if (!exists.isPresent()) {
			throw new ResourceNotFoundException("User with this id does not exist! - " + userId);
		}
		List<Question> createdUnansweredQuestions = new ArrayList<>();
		User currentUser = exists.get();
		List<Question> answeredQuestions = currentUser.getAnsweredQuestions()
				.stream()
				.map(q-> q.getQuestion())
				.collect(Collectors.toList());
		List<Question> createdQuestions = questionRepository.getCreatedQuestions();
		for (Question created: createdQuestions) {
			if (!answeredQuestions.contains(created)) {
				createdUnansweredQuestions.add(created);
			}
		}
		return createdUnansweredQuestions;
	}
}
