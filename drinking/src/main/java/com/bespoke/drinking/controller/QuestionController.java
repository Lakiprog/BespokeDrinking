package com.bespoke.drinking.controller;

import java.util.ArrayList;

import com.bespoke.drinking.model.Answer;
import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.model.Preference;
import com.bespoke.drinking.model.Question;
import com.bespoke.drinking.model.User;
import com.bespoke.drinking.service.QuestionService;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private KieContainer kieContainer;
	
	@Autowired
	private QuestionService service;

	@GetMapping(value = "/hotOrCold")
	public void hotOrCold() {
		KieSession kieSession = kieContainer.newKieSession("questions");
		
		User user = new User();
		user.setId(2);
		user.setCity("NS");
		user.setPassword("markuza2");
		user.setUsername("markuza2");
		
		Preference p = new Preference();
		p.setHot(null);
		user.setPreference(p);
		
		ArrayList<Question> questions = new ArrayList<>();
		
		Question q = new Question();
		q.setId(1);
		q.setText("Do you like hot or cold drinks?");
		
		ArrayList<Answer> answers = new ArrayList<>();
		
		Answer hot = new Answer();
		hot.setId(1);
		hot.setText("Hot");
		hot.setAnswerNumber(0);
		
		Answer cold = new Answer();
		cold.setId(2);
		cold.setText("Cold");
		cold.setAnswerNumber(1);
		
		answers.add(cold);
		answers.add(hot);
		
		q.setAnswers(answers);
		q.setSelectedAnswer(hot);
		
		questions.add(q);
		user.setAnsweredQuestions(questions);
		
		Question q2 = new Question();
		q2.setId(2);
		q2.setText("Do you drink coffee or tea more?");
		
		ArrayList<Answer> answers2 = new ArrayList<>();
		
		Answer coffee = new Answer();
		coffee.setId(3);
		coffee.setText("Coffee");
		coffee.setAnswerNumber(0);
		
		Answer tea = new Answer();
		tea.setId(4);
		tea.setText("Tea");
		tea.setAnswerNumber(1);
		
		answers2.add(coffee);
		answers2.add(tea);
		
		q2.setAnswers(answers2);
		q2.setSelectedAnswer(coffee);
		
		questions.add(q2);
		user.setAnsweredQuestions(questions);
		
		kieSession.insert(user);
		int fired = kieSession.fireAllRules();
		
		System.out.println("Number of Rules executed = " + fired);
		System.out.println("Preference (Is hot?): " + p.getHot());
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAnsweredQuestion(@RequestBody Question question, @PathVariable int id) {
		service.addAnsweredQuestion(id, question);
	}
}
