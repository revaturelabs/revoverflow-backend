package com.revature.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

//	@Modifying(clearAutomatically = true)
//	@Query("UPDATE Questions q SET q.acceptedId = ?1 WHERE q.id = ?2")
//	void updateQuestionAcceptedAnswerId(@Param("id") int id, @Param("acceptedId") int acceptedId);
//	Question updateQuestionByAcceptedId
	
}
