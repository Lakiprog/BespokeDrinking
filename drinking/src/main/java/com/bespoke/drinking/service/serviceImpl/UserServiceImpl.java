package com.bespoke.drinking.service.serviceImpl;

import com.bespoke.drinking.exception.ResourceExistsException;
import com.bespoke.drinking.exception.ResourceNotFoundException;
import com.bespoke.drinking.model.AnsweredQuestion;
import com.bespoke.drinking.model.Preference;
import com.bespoke.drinking.model.Role;
import com.bespoke.drinking.model.User;
import com.bespoke.drinking.repository.PreferenceRepository;
import com.bespoke.drinking.repository.RoleRepository;
import com.bespoke.drinking.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bespoke.drinking.service.UserService;
import com.bespoke.drinking.utils.Constants;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PreferenceRepository preferenceRepo;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getOne(int id) {
		Optional<User> exists =  userRepository.findById(id);
		if (!exists.isPresent()) {
			throw new ResourceNotFoundException("User with this id does not exist! - " + id);
		}
		return exists.get();
	}

	@Override
	public User save(User user) {
		User exists = userRepository.findByUsername(user.getUsername());
		if (exists != null) {
			throw new ResourceExistsException("User with this username already exists! - " + user.getUsername());
		}
		List<Role> roles = new ArrayList<Role>();
		Role role =  roleRepository.findByName(Constants.ROLE_USER);
		roles.add(role);
		user.setRoles(roles);
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public void addAllergies(int id, List<String> allergies) {
		Optional<User> exists = userRepository.findById(id);
		if(!exists.isPresent()) {
			throw new ResourceNotFoundException("User with this id does not exist! - " + id);
		}
		User user = exists.get();
		Preference p = new Preference();
		p.setUser(user);
		p.setAllergies(allergies);
		p = preferenceRepo.save(p);
		user.setPreference(p);
		userRepository.save(user);
	}

	@Override
	public Boolean hasFilled(int id) {
		Optional<User> exists =  userRepository.findById(id);
		if (!exists.isPresent()) {
			throw new ResourceNotFoundException("User with this id does not exist! - " + id);
		}
		User user = exists.get();
		
		for (AnsweredQuestion question : user.getAnsweredQuestions()) {
			if(question.getQuestion().getText().equals("What kind of ingredients do you prefer?") && question.isProcessed()) {
				return true;
			}
		}
		
		return false;
	}
}
