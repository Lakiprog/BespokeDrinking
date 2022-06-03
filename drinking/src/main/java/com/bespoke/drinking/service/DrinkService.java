package com.bespoke.drinking.service;

import java.util.List;

import com.bespoke.drinking.dto.DrinkDTO;
import com.bespoke.drinking.model.Drink;

public interface DrinkService {

	List<Drink> getAll();
	
	Drink getOne(int id);
	
	List<DrinkDTO> getBestDrinks(Integer userId);
}
