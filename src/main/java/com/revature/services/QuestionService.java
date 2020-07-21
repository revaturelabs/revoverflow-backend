package com.revature.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Question;
import com.revature.entities.User;
import com.revature.DTOs.RSSAccountDTO;
import com.revature.repositories.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	RSSService rssService;	
	
	@Autowired
	QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	/**@author ken*/
	public Page<Question> getAllQuestions(Pageable pageable){
		return questionRepository.findAll(pageable);
	}

	/**@author ken*/
	public Page<Question> getAllQuestionsByUserId(Pageable pageable, int id){
		return questionRepository.getAllQuestionsByUserID(pageable, id);		
	}
	
	/** @Author James Walls */
	public Question save(Question question) {
		return questionRepository.save(question);
	}

	/**@author Hugh Thornhill*/
	public Question updateQuestionAcceptedAnswerId(Question question) {
		if(question.getId() == 0) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}	
		return save(question);
	}
	
	/**@author Hugh Thornhill*/
	public Question updateQuestionStatus(Question question, int userId, int points) {
		// check the question accepted answer id is there
		if(question.getId() == 0 && question.getAcceptedId() == 0) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
		
		RSSAccountDTO dto = new RSSAccountDTO(userId, points);
		User user = rssService.addPoints(dto);
		if (user == null) {
			throw new NullPointerException("Null value");
		}
		return save(question);
	}
	
  /** @Author Natasha Poser */ 
	public Page <Question> getQuestionById(Pageable pageable, int id) {
		return questionRepository.getQuestionById(pageable, id);
	}

	/**@author ken*/
	public Page<Question> getAllQuestionsByStatus(Pageable pageable, boolean status){
		return questionRepository.getQuestionsByStatus(pageable, status);
	}
	
}
