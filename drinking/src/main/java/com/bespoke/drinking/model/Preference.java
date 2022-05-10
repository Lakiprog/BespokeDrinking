package com.bespoke.drinking.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preference")
public class Preference {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private boolean alcoholic, hot, caffeine;
	
//	private Map<Texture, Double> texture;
//	private List<String> allergies;
//	private Map<Flavour, Double> taste;
	
	@OneToOne
	private User user;
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
//	public Map<Texture, Double> getTexture() {
//		return texture;
//	}
//	public void setTexture(Map<Texture, Double> texture) {
//		this.texture = texture;
//	}
//	public List<String> getAllergies() {
//		return allergies;
//	}
//	public void setAllergies(List<String> allergies) {
//		this.allergies = allergies;
//	}
//	public Map<Flavour, Double> getTaste() {
//		return taste;
//	}
//	public void setTaste(Map<Flavour, Double> taste) {
//		this.taste = taste;
//	}
	
	
}
