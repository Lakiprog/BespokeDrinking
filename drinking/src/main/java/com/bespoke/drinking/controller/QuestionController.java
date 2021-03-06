package com.bespoke.drinking.controller;

import com.bespoke.drinking.dto.NewQuestion;
import com.bespoke.drinking.model.AnsweredQuestion;
import com.bespoke.drinking.model.Question;
import com.bespoke.drinking.service.QuestionService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Question> addAnsweredQuestion(@RequestBody AnsweredQuestion answeredQuestion, @PathVariable Integer userId) {
		return new ResponseEntity<Question>(service.addAnsweredQuestion(userId, answeredQuestion), HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/createNewQuestion", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity createNewQuestion(@RequestBody NewQuestion newQuestion) throws IOException {
		service.createNewQuestion(newQuestion);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/getUnansweredCreatedQuestions/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<List<Question>> getUnansweredCreatedQuestions(@PathVariable Integer userId) {
		return new ResponseEntity<List<Question>>(service.getUnansweredCreatedQuestions(userId), HttpStatus.OK);
	}
}
