package com.bespoke.drinking.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.repository.DrinkRepository;
import com.bespoke.drinking.service.DrinkService;

@Service
public class DrinkServiceImpl implements DrinkService{

	@Autowired
	DrinkRepository repository;

	@Override
	public List<Drink> getAll() {
		return repository.findAll();
	}

	@Override
	public Drink getOne(int id) {
		return repository.getById(id);
	}
	
	
}
