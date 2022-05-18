package com.bespoke.drinking.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.model.Flavour;
import com.bespoke.drinking.model.Preference;
import com.bespoke.drinking.model.Restaurant;
import com.bespoke.drinking.model.Texture;
import com.bespoke.drinking.model.User;
import com.bespoke.drinking.service.DrinkService;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drink")
public class DrinkController {

	@Autowired
	private KieContainer kieContainer;
	
	@Autowired
	private DrinkService service;
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = "/getBestDrinks")
	public void getBestDrinks() {
		KieSession kieSession = kieContainer.newKieSession("questions");
		
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
		
		kieSession.insert(p);
		kieSession.insert("NS");
		kieSession.insert(drinks);
		int fired = kieSession.fireAllRules();
		List<Drink> bestDrinks = (List<Drink>) kieSession.getGlobal("bestDrinks");
		System.out.println("Number of Rules executed = " + fired);
		System.out.println(bestDrinks);
	}
	
	@GetMapping(value = "")
	public List<Drink> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Drink getOne(@PathVariable("id") int id){
		return service.getOne(id);
	}
}
