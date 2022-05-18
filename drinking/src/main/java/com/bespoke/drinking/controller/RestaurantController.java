package com.bespoke.drinking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.model.Restaurant;
import com.bespoke.drinking.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	RestaurantService service;
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Restaurant> getAll(){
		return service.getAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Restaurant getOne(@PathVariable("id") int id){
		return service.getOne(id);
	}
	
	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Restaurant save(@RequestBody Restaurant restaurant) {
		return service.save(restaurant);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addDrink(@RequestBody Drink drink, @PathVariable int id) {
		service.addDrink(id, drink);
	}
}
