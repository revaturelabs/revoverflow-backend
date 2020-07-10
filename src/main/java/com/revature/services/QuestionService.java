package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.revature.entities.Questions;
import com.revature.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	public Page<Questions> getAllQuestions(Pageable pageable){
		return questionRepository.findAll(pageable);
	}
	
	public Questions save(Questions question) {
		return questionRepository.save(question);
	}
}
