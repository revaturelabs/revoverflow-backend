package com.revature.repositories;



import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.revature.entities.Answer;
import com.revature.entities.Question;



@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question, Integer>, JpaRepository<Question, Integer>{

	/**@author ken*/
	Page<Question> getAllQuestionsByUserID(Pageable pageable, int id);

	/**@author ken*/
	Page<Question> getAllQuestionsByStatus(Pageable pageable, boolean status);
	
	/** @author Natasha Poser 
	Page<Question> getRecentQuestions(Pageable pageable, LocalDate creation_date);
	*/
	
}
