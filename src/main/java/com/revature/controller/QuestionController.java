package com.revature.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// works
	/**	 *@author ken */
	@GetMapping
	public Page<Question> getAllQuestions(Pageable pageable)
	{
		return questionService.getAllQuestions(pageable);
	}
	
	// works
	/**@author Hugh Thornhill*/
	@PutMapping
	public Question updateQuestionAcceptedAnswerId(@RequestBody Question question) {
		return questionService.updateQuestionAcceptedAnswerId(question);
	}
	
	// works
	/**@author Hugh Thornhill*/
	@PutMapping("/status")
	public Question updateStatus(@RequestBody Question question) {
		return questionService.updateQuestionStatus(question);
	}

	// DOES NOT work
	/**@author ken*/
	@GetMapping("/{statusId}")
	public Page<Question> getAllQuestionsByStatus(Pageable pageable, @PathVariable boolean status)
	{
		return questionService.getAllQuestionsByStatus(pageable, status);
	}

	// works
	/**@author ken*/
	@GetMapping("/user/{id}")
	public Page<Question> getAllQuestionsByUserId(Pageable pageable, @PathVariable int id)
	{
		return questionService.getAllQuestionsByUserId(pageable, id);
	}

	// works
	/** @Author James Walls */
	@PostMapping
	public Question saveQuestion(@Valid @RequestBody Question question) {
		return questionService.save(question);
	}

	// DOES NOT work
	/** @Author Natasha Poser */
	@GetMapping("/{id}")
	public Question getQuestionByQuestionId(@PathVariable int id) {
		return questionService.findById(id);
	}
}