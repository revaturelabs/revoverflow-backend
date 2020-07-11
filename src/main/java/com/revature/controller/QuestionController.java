package com.revature.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.revature.entities.Question;
import com.revature.services.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping
	public Page<Question> getAllQuestions(Pageable pageable)
	{
		return questionService.getAllQuestions(pageable);
	}
	
	@GetMapping("/{statusId}")
	public Page<Question> getAllQuestionsByStatus(Pageable pageable, @PathVariable boolean status)
	{
		return questionService.getAllQuestionsByStatus(pageable, status);
	}

	@GetMapping("/user/{id}")
	public Page<Question> getAllQuestionsByUserId(Pageable pageable, @PathVariable int id)
	{
		return questionService.getAllQuestionsByUserId(pageable, id);
	}

	@PostMapping
	public Question saveQuestion(Question question) {
		return questionService.save(question);
	}
}