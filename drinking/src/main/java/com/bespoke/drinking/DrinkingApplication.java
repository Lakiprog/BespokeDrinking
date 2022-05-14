package com.bespoke.drinking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bespoke.drinking.model.Answer;
import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.model.Flavour;
import com.bespoke.drinking.model.Preference;
import com.bespoke.drinking.model.Question;
import com.bespoke.drinking.model.Restaurant;
import com.bespoke.drinking.model.Texture;
import com.bespoke.drinking.model.User;


@SpringBootApplication
public class DrinkingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DrinkingApplication.class, args);
		
//		KieServices ks = KieServices.Factory.get();
//		KieContainer kContainer = ks.getKieClasspathContainer();
//		KieSession kSession = kContainer.newKieSession("questions");
//		
//		User user = new User();
//		user.setId(2);
//		user.setCity("NS");
//		user.setPassword("markuza2");
//		user.setUsername("markuza2");
//		
//		Preference p = new Preference();
//		p.setHot(null);
//		user.setPreference(p);
//		
//		ArrayList<Question> questions = new ArrayList<>();
//		
//		Question q = new Question();
//		q.setId(1);
//		q.setText("Do you like hot or cold drinks?");
//		
//		ArrayList<Answer> answers = new ArrayList<>();
//		
//		Answer hot = new Answer();
//		hot.setId(1);
//		hot.setText("Hot");
//		hot.setAnswerNumber(0);
//		
//		Answer cold = new Answer();
//		cold.setId(2);
//		cold.setText("Cold");
//		cold.setAnswerNumber(1);
//		
//		answers.add(cold);
//		answers.add(hot);
//		
//		q.setAnswers(answers);
//		q.setSelectedAnswer(hot);
//		
//		questions.add(q);
//		user.setAnsweredQuestions(questions);
//		
//		Question q2 = new Question();
//		q2.setId(2);
//		q2.setText("Do you drink coffee or tea more?");
//		
//		ArrayList<Answer> answers2 = new ArrayList<>();
//		
//		Answer coffee = new Answer();
//		coffee.setId(3);
//		coffee.setText("Coffee");
//		coffee.setAnswerNumber(0);
//		
//		Answer tea = new Answer();
//		tea.setId(4);
//		tea.setText("Tea");
//		tea.setAnswerNumber(1);
//		
//		answers2.add(coffee);
//		answers2.add(tea);
//		
//		q2.setAnswers(answers2);
//		q2.setSelectedAnswer(coffee);
//		
//		questions.add(q2);
//		user.setAnsweredQuestions(questions);
//		
//		kSession.insert(user);
//		int fired = kSession.fireAllRules();
//		
//		System.out.println("Number of Rules executed = " + fired);
//		System.out.println("Preference (Is hot?): " + p.getHot());
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession rec = kContainer.newKieSession("questions");
		
		List<String> ingredients1 = new ArrayList<String>();
		ingredients1.add("ingredient 1");
		ingredients1.add("ingredient 2");
		ingredients1.add("ingredient 3");
		
		List<String> ingredients2 = new ArrayList<String>();
		ingredients2.add("ingredient 4");
		ingredients2.add("ingredient 5");
		
		Map<Flavour, Double> tastes1 = new HashMap<Flavour, Double>();
		tastes1.put(Flavour.SOUR, 9.0);
		tastes1.put(Flavour.BITTER, 6.0);
		
		Map<Flavour, Double> tastes2 = new HashMap<Flavour, Double>();
		tastes2.put(Flavour.SWEET, 8.0);
		
		Restaurant r1 = new Restaurant();
		r1.setCity("NS");
		r1.setName("RES 1");
		r1.setId(1);
		
		Drink d1 = new Drink();
		d1.setAlcoholic(true);
		d1.setCaffeine(false);
		d1.setHot(false);
		d1.setName("Pivo 1");
		d1.setTexture(Texture.LIQUID);
		d1.setIngredients(ingredients1);
		d1.setTaste(tastes1);
		d1.setRestaurant(r1);
		d1.setId(1);
		
		Drink d2 = new Drink();
		d2.setAlcoholic(true);
		d2.setCaffeine(false);
		d2.setHot(false);
		d2.setName("Pivo 2");
		d2.setTexture(Texture.LIQUID);
		d2.setIngredients(ingredients1);
		d2.setTaste(tastes1);
		d2.setRestaurant(r1);
		d2.setId(2);
		
		Drink d3 = new Drink();
		d3.setAlcoholic(false);
		d3.setCaffeine(true);
		d3.setHot(true);
		d3.setName("Kafa");
		d3.setTexture(Texture.HALF_THICC);
		d3.setIngredients(ingredients2);
		d3.setTaste(tastes2);
		d3.setRestaurant(r1);
		d3.setId(3);
		
		List<Drink> drinks = new ArrayList<Drink>();
		drinks.add(d1);
		drinks.add(d2);
		drinks.add(d3);
		
		List<String> allergies = new ArrayList<String>();
		allergies.add("ingredient 1");
		
		User user = new User();
		user.setId(2);
		user.setCity("NS");
		user.setPassword("markuza2");
		user.setUsername("markuza2");
		
		Map<Flavour, Double> userTastes = new HashMap<Flavour, Double>();
		userTastes.put(Flavour.SOUR, 9.0);
		userTastes.put(Flavour.BITTER, 6.0);
		
		Map<Texture, Double> userTex = new HashMap<Texture, Double>();
		userTex.put(Texture.LIQUID, 9.0);
		userTex.put(Texture.HALF_THICC, 2.0);
		userTex.put(Texture.THICC, 1.0);
		
		Preference p = new Preference();
		p.setHot(false);
		p.setAlcoholic(true);
		p.setAllergies(ingredients1);
		
		user.setPreference(p);
		
		p.setAlcoholic(true);
		p.setAllergies(allergies);
		p.setCaffeine(false);
		p.setTaste(userTastes);
		p.setHot(false);
		p.setTexture(userTex);
		p.setId(1);
		p.setUser(user);
		
		rec.insert(p);
		rec.insert("NS");
		rec.insert(drinks);
		int fired = rec.fireAllRules();
		List<Drink> bestDrinks = (List<Drink>) rec.getGlobal("bestDrinks");
		System.out.println("Number of Rules executed = " + fired);
		System.out.println(bestDrinks);
		
	}
}
