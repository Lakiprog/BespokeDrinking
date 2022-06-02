package com.bespoke.drinking.service;

import java.util.List;

import com.bespoke.drinking.dto.BestDrinksDTO;
import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.model.Restaurant;

public interface RestaurantService {

	List<Restaurant> getAll();
	
	Restaurant getOne(int id);
	
	Restaurant save(Restaurant restaurant);
	
	void addDrink(int id, Drink drink);
	
	Restaurant getBestRestaurant(BestDrinksDTO drinks);
}
