package com.bespoke.drinking.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bespoke.drinking.dto.BestDrinksDTO;
import com.bespoke.drinking.exception.ResourceNotFoundException;
import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.model.Restaurant;
import com.bespoke.drinking.repository.RestaurantRepository;
import com.bespoke.drinking.service.RestaurantService;

@Service
public class RestaurantServiceImpl  implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private KieContainer kieContainer;

	@Override
	public List<Restaurant> getAll() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant getOne(int id) {
		Optional<Restaurant> exists =  restaurantRepository.findById(id);
		if (!exists.isPresent()) {
			throw new ResourceNotFoundException("Restaurant with this id does not exist! - " + id);
		}
		return exists.get();
	}

	@Override
	public Restaurant save(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public void addDrink(int id, Drink drink) {
		Restaurant restaurant = getOne(id);
		drink.setRestaurant(restaurant);
		restaurant.addDrink(drink);
		restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant getBestRestaurant(BestDrinksDTO drinks) {
		KieSession kieSession = kieContainer.newKieSession("questions");
		kieSession.insert(drinks);
		kieSession.fireAllRules();
		Integer bestRestaurant = (Integer) kieSession.getGlobal("bestRestaurant");
		Optional<Restaurant> exists =  restaurantRepository.findById(bestRestaurant);
		if (!exists.isPresent()) {
			throw new ResourceNotFoundException("Restaurant with this id does not exist! - " + bestRestaurant);
		}
		return exists.get();
	}
}