package com.bespoke.drinking.service;

import java.util.List;

import com.bespoke.drinking.model.User;

public interface UserService {
	
	List<User> getAll();
	
	User getOne(int id);
	
	Boolean hasFilled(int id);
	
	User save(User user);
	
	void addAllergies(int id, List<String> allergies);
}
