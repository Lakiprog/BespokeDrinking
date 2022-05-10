package com.bespoke.drinking.model;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "drink")
public class Drink {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private boolean alcoholic, hot, caffeine;
	
	@Column
	private Texture texture;
	
	@ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name = "drink_ingredients", joinColumns = @JoinColumn(name = "drink_id"))
    @Column(name = "ingredient")
	private List<String> ingredients;
	
	@ElementCollection(fetch=FetchType.EAGER)
    @MapKeyColumn(name="taste")
    @Column(name="value")
    @CollectionTable(name="drink_tastes", joinColumns=@JoinColumn(name="drink_id"))
	private Map<Flavour, Double> taste;
	
	@ManyToOne
	Restaurant restaurant;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isAlcoholic() {
		return alcoholic;
	}
	
	public void setAlcoholic(boolean alcoholic) {
		this.alcoholic = alcoholic;
	}
	
	public boolean isHot() {
		return hot;
	}
	
	public void setHot(boolean hot) {
		this.hot = hot;
	}
	
	public boolean isCaffeine() {
		return caffeine;
	}
	
	public void setCaffeine(boolean caffeine) {
		this.caffeine = caffeine;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public List<String> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	public Map<Flavour, Double> getTaste() {
		return taste;
	}
	
	public void setTaste(Map<Flavour, Double> taste) {
		this.taste = taste;
	}
}
