package com.bespoke.drinking.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String username, password, city;
	
	@OneToOne
	private Preference preference;
	
	@ElementCollection(fetch=FetchType.LAZY)
    @Column(name="answered_questions")
    @CollectionTable(name="user_answeredQuestions", joinColumns=@JoinColumn(name="user_id"))
	private List<AnsweredQuestion> answeredQuestions;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonIgnore
	public Preference getPreference() {
		return preference;
	}

	public void setPreference(Preference preference) {
		this.preference = preference;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonIgnore
	public List<AnsweredQuestion> getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void setAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}
	
	public void addAnsweredQuestion(AnsweredQuestion answeredQuestion) {
		this.answeredQuestions.add(answeredQuestion);
	}
}
