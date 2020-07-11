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
 
 public Page<Answer> getAnswerByQuestionId(Pageable pageable, int question_id){
	 return answerRepository.getAnswerByQuestionId(pageable, question_id);
 }
 
 public Page<Answer> getAnswers(Pageable pageable) {
	 return answerRepository.findAll(pageable);
 }
	

}


