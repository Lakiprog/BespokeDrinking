package com.bespoke.drinking.service.serviceImpl;

import com.bespoke.drinking.model.User;
import com.bespoke.drinking.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bespoke.drinking.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;

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
	
	
}
