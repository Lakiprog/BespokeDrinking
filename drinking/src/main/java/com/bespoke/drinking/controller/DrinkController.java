package com.bespoke.drinking.controller;

import java.util.List;

import com.bespoke.drinking.dto.DrinkDTO;
import com.bespoke.drinking.dto.SearchFilterDrinksDTO;
import com.bespoke.drinking.model.Drink;
import com.bespoke.drinking.service.DrinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drink")
public class DrinkController {

	@Autowired
	private DrinkService service;
	
	@GetMapping(value = "/getBestDrinks/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<List<DrinkDTO>> getBestDrinks(@PathVariable Integer userId) {
		return new ResponseEntity<List<DrinkDTO>>(service.getBestDrinks(userId), HttpStatus.OK);
	}
	
	@GetMapping(value = "")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public List<DrinkDTO> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Drink getOne(@PathVariable("id") int id){
		return service.getOne(id);
	}
	
	@PostMapping(value = "/searchAndFilter", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public ResponseEntity<List<DrinkDTO>>  searchAndFilter(@RequestBody SearchFilterDrinksDTO searchFilterDTO) {
		return new ResponseEntity<List<DrinkDTO>>(service.searchAndFilter(searchFilterDTO), HttpStatus.OK);
	}
}
