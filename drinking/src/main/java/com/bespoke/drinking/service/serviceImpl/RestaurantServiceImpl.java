package com.bespoke.drinking.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bespoke.drinking.exception.ResourceNotFoundException;
import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.model.Restaurant;
import com.bespoke.drinking.repository.RestaurantRepository;
import com.bespoke.drinking.service.RestaurantService;

@Service
public class RestaurantServiceImpl  implements RestaurantService{

	@Autowired
	RestaurantRepository repository;

	@Override
	public List<Restaurant> getAll() {
		return repository.findAll();
	}

	@Override
	public Restaurant getOne(int id) {
		Optional<Restaurant> exists =  repository.findById(id);
		if (!exists.isPresent()) {
			throw new ResourceNotFoundException("Restaurant with this id does not exist! - " + id);
		}
		return exists.get();
	}

	@Override
	public Restaurant save(Restaurant restaurant) {
		return repository.save(restaurant);
	}

	@Override
	public void addDrink(int id, Drink drink) {
		Restaurant restaurant = getOne(id);
		drink.setRestaurant(restaurant);
		restaurant.addDrink(drink);
		repository.save(restaurant);
	}
}
