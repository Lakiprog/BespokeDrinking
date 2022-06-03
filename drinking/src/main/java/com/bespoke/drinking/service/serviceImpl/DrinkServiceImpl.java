package com.bespoke.drinking.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bespoke.drinking.dto.DrinkDTO;
import com.bespoke.drinking.dto.SearchFilterDrinksDTO;
import com.bespoke.drinking.exception.ResourceNotFoundException;
import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.model.User;
import com.bespoke.drinking.repository.DrinkRepository;
import com.bespoke.drinking.repository.RestaurantRepository;
import com.bespoke.drinking.repository.UserRepository;
import com.bespoke.drinking.service.DrinkService;

@Service
public class DrinkServiceImpl implements DrinkService {
	
	@Autowired
	private KieContainer kieContainer;

	@Autowired
	private DrinkRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public List<DrinkDTO> getAll() {
		List<Drink> drinks =  repository.findAll();
		ArrayList<DrinkDTO> dtos = new ArrayList<>();
		
		for (Drink drink : drinks) {
			dtos.add(new DrinkDTO(drink));
		}
		return dtos;
	}

	@Override
	public Drink getOne(int id) {
		Optional<Drink> exists =  repository.findById(id);
		if (!exists.isPresent()) {
			throw new ResourceNotFoundException("Drink with this id does not exist! - " + id);
		}
		return exists.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Drink> getBestDrinks(Integer userId) {
		Optional<User> exists = userRepository.findById(userId);
		if (!exists.isPresent()) {
			throw new ResourceNotFoundException("User with this id does not exist! - " + userId);
		}
		User user = exists.get();
		KieSession kieSession = kieContainer.newKieSession("questions");
		kieSession.insert(user.getPreference());
		kieSession.insert(user.getCity());
		kieSession.insert(repository.findAll());
		kieSession.insert(restaurantRepository.findAll());
		kieSession.fireAllRules();
		List<Drink> bestDrinks = (List<Drink>) kieSession.getGlobal("bestDrinks");
		return bestDrinks;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DrinkDTO> searchAndFilter(SearchFilterDrinksDTO searchAndFilterDto) {
		KieSession kieSession = kieContainer.newKieSession("questions");
		kieSession.getAgenda().getAgendaGroup("search-filter-drinks").setFocus();
		List<Drink> drinks = repository.findAll();
		drinks.forEach(e -> e.getIngredients().replaceAll(String::toLowerCase));
		kieSession.insert(drinks);
		kieSession.insert(searchAndFilterDto);
		kieSession.fireAllRules();
		List<Drink> searchAndFilterDrinksResult = (List<Drink>) kieSession.getGlobal("searchAndFilterDrinksResult");
		List<DrinkDTO> finalDrinks = new ArrayList<DrinkDTO>();
		for (Drink d : searchAndFilterDrinksResult) {
			finalDrinks.add(new DrinkDTO(d));
		}
		return finalDrinks;
	}
}
