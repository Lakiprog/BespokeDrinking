package com.bespoke.drinking;

import java.util.ArrayList;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bespoke.drinking.model.Answer;
import com.bespoke.drinking.model.Preference;
import com.bespoke.drinking.model.Question;
import com.bespoke.drinking.model.User;


@SpringBootApplication
public class DrinkingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DrinkingApplication.class, args);
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("questions");
		
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
		
		kSession.insert(user);
		int fired = kSession.fireAllRules();
		
		System.out.println("Number of Rules executed = " + fired);
		System.out.println("Preference (Is hot?): " + p.getHot());
	}
}
