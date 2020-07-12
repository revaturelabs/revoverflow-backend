package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Question;
import com.revature.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	public Page<Question> getAllQuestions(Pageable pageable){
		return questionRepository.findAll(pageable);
	}
	
	/** @Author James Walls */
	public Question save(Question question) {
		return questionRepository.save(question);
	}
	
	public Question findById(int id) {
		return questionRepository.findById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
}
