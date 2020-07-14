package com.revature.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
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
	
	/**	 *@author ken */
	@GetMapping
	public Page<Question> getAllQuestions(Pageable pageable)
	{
		return questionService.getAllQuestions(pageable);
	}
	
	/**@author Hugh Thornhill*/
	@PatchMapping("/questions")
	public Question updateQuestionAcceptedAnswerId(Question question) {
		return questionService.updateQuestionAcceptedAnswerId(question);
	}
	
	/**@author Hugh Thornhill*/
	@PatchMapping("/questions/status")
	public Question updateStatus(Question question) {
		return questionService.updateStatus(question);
	}

	/**@author ken*/
	@GetMapping("/{statusId}")
	public Page<Question> getAllQuestionsByStatus(Pageable pageable, @PathVariable boolean status)
	{
		return questionService.getAllQuestionsByStatus(pageable, status);
	}
	
//	@PatchMapping("/questions/status")
//	public Question updateStatus(Question question) {
//		return questionService.updateStatus(question);
//	}

	/**@author ken*/
	@GetMapping("/user/{id}")
	public Page<Question> getAllQuestionsByUserId(Pageable pageable, @PathVariable int id)
	{
		return questionService.getAllQuestionsByUserId(pageable, id);
	}

	/** @Author James Walls */
	@PostMapping
	public Question saveQuestion(Question question) {
		return questionService.save(question);
	}

	/** @Author Natasha Poser */
	@GetMapping("/{id}")
	public Question getQuestionByQuestionId(@PathVariable int id) {
		return questionService.findById(id);
	}
	
//	@PatchMapping("/questions")
//	public Question updateQuestionAcceptedAnswerId(Question question) {
//		return questionService.updateQuestionAcceptedAnswerId(question);
//	}
}