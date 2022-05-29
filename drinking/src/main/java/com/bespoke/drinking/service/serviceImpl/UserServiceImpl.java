package com.bespoke.drinking.service.serviceImpl;

import com.bespoke.drinking.exception.ResourceNotFoundException;
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
	UserRepository repository;
	
	@Autowired
	private PreferenceRepository preferenceRepo;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> getAll() {
		return repository.findAll();
	}

	@Override
	public User getOne(int id) {
		Optional<User> exists =  repository.findById(id);
		if (!exists.isPresent()) {
			throw new ResourceNotFoundException("User with this id does not exist! - " + id);
		}
		return exists.get();
	}

	@Override
	public User save(User user) {
		List<Role> roles = new ArrayList<Role>();
		Role role =  roleRepository.findByName(Constants.ROLE_USER);
		roles.add(role);
		user.setRoles(roles);
		user.setEnabled(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}

	@Override
	public void addAllergies(int id, List<String> allergies) {
		Optional<User> exists = repository.findById(id);
		if(!exists.isPresent()) {
			throw new ResourceNotFoundException("User with this id does not exist! - " + id);
		}
		User user = exists.get();
		Preference p = new Preference();
		p.setUser(user);
		p.setAllergies(allergies);
		p = preferenceRepo.save(p);
		user.setPreference(p);
		repository.save(user);
	}
}
