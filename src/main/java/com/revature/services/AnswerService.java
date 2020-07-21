package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.revature.entities.Answer;
import com.revature.repositories.AnswerRepository;

@Service
public class AnswerService {
	
 @Autowired
 AnswerRepository answerRepository;
 
  /** @Author Natasha Poser */
 public Page<Answer> getAnswerByQuestionId(Pageable pageable, int id){
	 return answerRepository.getAnswerByQuestionId(pageable, id);
 }
 
 public Page<Answer> getAnswers(Pageable pageable) {
	 return answerRepository.findAll(pageable);
 }
	
	/** @Author James Walls */
	public Answer save(Answer answer) {
		return answerRepository.save(answer);
	}

	/**@author ken*/
	public Page<Answer> getAllAnswersByUserID(Pageable pageable, int id){
		return answerRepository.getAllAnswersByUserId(pageable, id);		
	}
	
}


