package com.bespoke.drinking.model;

import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity
@Table(name = "preference")
public class Preference {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Boolean alcoholic, hot, caffeine;
	
	@ElementCollection(fetch=FetchType.EAGER)
    @MapKeyColumn(name="texture")
    @Column(name="value")
    @CollectionTable(name="preference_textures", joinColumns=@JoinColumn(name="preference_id"))
	private Map<Texture, Double> texture;
	
	@ElementCollection(fetch=FetchType.LAZY)
    @CollectionTable(name = "preference_allergies", joinColumns = @JoinColumn(name = "preference_id"))
    @Column(name = "allergy")
	private List<String> allergies;
	
	@ElementCollection(fetch=FetchType.EAGER)
    @MapKeyColumn(name="taste")
    @Column(name="value")
    @CollectionTable(name="preference_tastes", joinColumns=@JoinColumn(name="preference_id"))
	private Map<Flavour, Double> taste;
	
	@OneToOne
	private User user;
	
	public Boolean getAlcoholic() {
		return alcoholic;
	}

	public void setAlcoholic(Boolean alcoholic) {
		this.alcoholic = alcoholic;
	}

	public Boolean getHot() {
		return hot;
	}

	public void setHot(Boolean hot) {
		this.hot = hot;
	}

	public Boolean getCaffeine() {
		return caffeine;
	}

	public void setCaffeine(Boolean caffeine) {
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
	
	public Map<Texture, Double> getTexture() {
		return texture;
	}
	
	public void setTexture(Map<Texture, Double> texture) {
		this.texture = texture;
	}
	
	public List<String> getAllergies() {
		return allergies;
	}
	
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}
	
	public Map<Flavour, Double> getTaste() {
		return taste;
	}
	
	public void setTaste(Map<Flavour, Double> taste) {
		this.taste = taste;
	}
}
