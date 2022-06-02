package com.bespoke.drinking.dto;

import java.util.List;

import com.bespoke.drinking.model.Drink;

public class BestDrinksDTO {

	List<Drink> drinks;

	public List<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}
}
