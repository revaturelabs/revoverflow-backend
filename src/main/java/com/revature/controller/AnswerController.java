package com.revature.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.revature.entities.Answer;
import com.revature.services.AnswerService;

@RestController
@RequestMapping("/answers")
public class AnswerController {
	
	@Autowired
	AnswerService answerService;
	
/** @Author Natasha Poser */
	@GetMapping
	public Page<Answer>getAnswers(Pageable pageable,
			@RequestParam(required = false) int question_id){
		return answerService.getAnswers(pageable);
	}

	/** @Author James Walls */
	@PostMapping
	public Answer saveAnswer(Answer answer) {
		return answerService.save(answer);
	}
	
	/**@author ken*/
	@GetMapping("/user/{id}")
	public Page<Answer> getAllAnswersByUserID(Pageable pageable, int id){
		return answerService.getAllAnswersByUserID(pageable, id);		
	}

}
