package com.revature.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.revature.entities.Question;
import com.revature.services.QuestionService;

import ch.qos.logback.classic.Logger;

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
	
//	@PatchMapping("/questions/")
//	public Question updateQuestionAcceptedAnswerId(@PathVariable int id, @PathVariable int acceptedId,
//			@RequestBody Question question)
//	{
//		try {
//			questionService.updateQuestionAcceptedAnswerId(id, acceptedId);
//			return Question.ok().build();
//	} catch (ResourseNotFoundException ex) {
//		logger.error(ex.getMessage());
//		return Question.notFound().build();
//	}

	@PostMapping
	public Question saveQuestion(Question question) {
		return questionService.save(question);
	}
	
}