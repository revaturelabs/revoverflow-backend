package com.revature.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.revature.entities.Answer;
import com.revature.repositories.AnswerRepository;

@Service
public class AnswerService {

	AnswerRepository answerRepository;
	
	public Page<Answer> getAllAnswersByUserID(Pageable pageable, int id){
		return answerRepository.getAllAnswersByUserId(pageable, id);		
	}
}
