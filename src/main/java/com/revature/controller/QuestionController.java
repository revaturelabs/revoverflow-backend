package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.revature.entities.Questions;
import com.revature.services.QuestionService;

@RestController
@RequestMapping("/Question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping
	
	
	@PostMapping
	public Questions saveQuestion(@Valid @RequestBody Questions question) {
		return questionService.save(question);
	}
	

}
