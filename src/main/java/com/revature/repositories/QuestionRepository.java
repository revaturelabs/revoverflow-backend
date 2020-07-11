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

	/**@author ken*/
	Page<Question> getAllQuestionsByUserID(Pageable pageable, int id);

	/**@author ken*/
	Page<Question> getAllQuestionsByStatus(Pageable pageable, boolean status);
	
//public interface QuestionRepository extends JpaRepository<Questions, Integer>{
//	@Modifying(clearAutomatically = true)
//	@Query("UPDATE Questions q SET q.accepted_answer_id = :accepted_answer_id WHERE q.id = :id")
//	int updateQuestionAcceptedAnswerId(@Param("id") int id, @Param("accepted_answer_id") int accepted_answer_id);
////	Page<Questions> 
//	@Query("UPDATE Questions q SET q.acceptedId = :acceptedId WHERE q.id = :id")
//	void updateQuestionAcceptedAnswerId(@Param("id") int id, @Param("acceptedId") int acceptedId);
////	Page<Question> updateQuestionAcceptAnswerId(Pageable pageable, int acceptedId);
	
//	@Modifying(clearAutomatically = true)
//	@Query("UPDATE Questions q SET q.acceptedId = ?1 WHERE q.id = ?2")
//	void updateQuestionAcceptedAnswerId(@Param("id") int id, @Param("acceptedId") int acceptedId);
////	Page<Question> updateQuestionAcceptAnswerId(Pageable pageable, int acceptedId); 

}
