package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.entities.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer>{
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Questions q SET q.accepted_answer_id = :accepted_answer_id WHERE q.id = :id")
	int updateQuestionAcceptedAnswerId(@Param("id") int id, @Param("accepted_answer_id") int accepted_answer_id);
//	Page<Questions> 
}
