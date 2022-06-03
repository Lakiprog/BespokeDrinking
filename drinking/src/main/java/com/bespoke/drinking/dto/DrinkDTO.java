package com.bespoke.drinking.dto;

import com.bespoke.drinking.model.Drink;

public class DrinkDTO {
	
	private int id;
	private String name, restaurant, city;
	private Drink drink;
	
	public DrinkDTO(Drink drink) {
		this.id = drink.getId();
		this.name = drink.getName();
		this.restaurant = drink.getRestaurant().getName();
		this.city = drink.getRestaurant().getCity();
		this.drink = drink;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}
	
	
}
