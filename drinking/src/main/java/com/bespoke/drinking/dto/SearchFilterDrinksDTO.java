package com.bespoke.drinking.dto;

public class SearchFilterDrinksDTO {

	private String name;
	
	private String restaurant;
	
	private String ingredient;
	
	private Boolean alcoholic;
	
	private Boolean caffeine;
	
	private Boolean hot;

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

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public Boolean getAlcoholic() {
		return alcoholic;
	}

	public void setAlcoholic(Boolean alcoholic) {
		this.alcoholic = alcoholic;
	}

	public Boolean getCaffeine() {
		return caffeine;
	}

	public void setCaffeine(Boolean caffeine) {
		this.caffeine = caffeine;
	}

	public Boolean getHot() {
		return hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}
}
