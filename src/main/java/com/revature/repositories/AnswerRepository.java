package com.revature.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	/** @author Natasha Poser */
	Page<Answer> getAnswerByQuestionId(Pageable pageable, int question_id);
	

	/**@author ken */
	Page<Answer> getAllAnswersByUserId(Pageable pageable, int id);
	

}
