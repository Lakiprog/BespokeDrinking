package com.bespoke.drinking.controller;

import java.util.List;

import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.service.DrinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drink")
public class DrinkController {

	@Autowired
	private DrinkService service;
	
	@GetMapping(value = "/getBestDrinks/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<List<Drink>> getBestDrinks(@PathVariable Integer userId) {
		return new ResponseEntity<List<Drink>>(service.getBestDrinks(userId), HttpStatus.OK);
	}
	
	@GetMapping(value = "")
	public List<Drink> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Drink getOne(@PathVariable("id") int id){
		return service.getOne(id);
	}
}
