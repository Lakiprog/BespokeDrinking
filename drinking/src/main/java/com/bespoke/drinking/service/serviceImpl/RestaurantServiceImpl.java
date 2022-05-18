package com.bespoke.drinking.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.model.Restaurant;
import com.bespoke.drinking.repository.RestaurantRepository;
import com.bespoke.drinking.service.RestaurantService;

public class RestaurantServiceImpl  implements RestaurantService{

	@Autowired
	RestaurantRepository repository;

	@Override
	public List<Restaurant> getAll() {
		return repository.findAll();
	}

	@Override
	public Restaurant getOne(int id) {
		return repository.getById(id);
	}

	@Override
	public Restaurant save(Restaurant restaurant) {
		return repository.save(restaurant);
	}

	@Override
	public void addDrink(int id, Drink drink) {
		Restaurant restaurant = getOne(id);
		restaurant.addDrink(drink);
		repository.save(restaurant);
	}
}
