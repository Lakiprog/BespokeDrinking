package com.bespoke.drinking.controller;

import com.bespoke.drinking.model.Question;
import com.bespoke.drinking.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService service;
	
	@PutMapping(value = "/addAnsweredQuestion/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Question> addAnsweredQuestion(@RequestBody Question question, @PathVariable Integer userId) {
		return new ResponseEntity<Question>(service.addAnsweredQuestion(userId, question), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAnsweredQuestion(@RequestBody Question question, @PathVariable int id) {
		service.addAnsweredQuestion(id, question);
	}
}
