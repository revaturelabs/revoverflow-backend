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
		System.out.println("I am the question = " + question.getTitle());
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
	public Question updateQuestionStatus(Question question) {
		// check the question accepted answer id is there
		if(question.getId() == 0 && question.getAcceptedId() == 0) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}	
		return save(question);
	}
	
	/**@author ken*/
	public Page<Question> getAllQuestionsByStatus(Pageable pageable, boolean status){
		return questionRepository.getAllQuestionsByStatus(pageable, status);
	}
	
	/** @author Natasha Poser */
	public Question findById(int id) {
		return questionRepository.findById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		}
	

	

}
