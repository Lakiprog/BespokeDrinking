package com.bespoke.drinking.service.serviceImpl;

import com.bespoke.drinking.exception.UserNotFoundException;
import com.bespoke.drinking.model.Preference;
import com.bespoke.drinking.model.User;
import com.bespoke.drinking.repository.PreferenceRepository;
import com.bespoke.drinking.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bespoke.drinking.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	
	@Autowired
	private PreferenceRepository preferenceRepo;

	@Override
	public List<User> getAll() {
		return repository.findAll();
	}

	@Override
	public User getOne(int id) {
		return repository.getById(id);
	}

	@Override
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public void addAllergies(int id, List<String> allergies) {
		User user = repository.getById(id);
		if(user == null) {
			throw new UserNotFoundException(id);
		}
		Preference p = new Preference();
		p.setUser(user);
		p.setAllergies(allergies);
		p = preferenceRepo.save(p);
		user.setPreference(p);
		repository.save(user);
	}
	
	
}
