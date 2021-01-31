package com.revature.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.entities.Faq;


@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer>{

	public List<Faq> findAll();
	
	@Query("From Faq f INNER JOIN Location l ON f.locationId = l.id WHERE :location = l.locationName")
	public List<Faq> getFaqByLocation(String location);

	@Query("From Faq f INNER JOIN Question q ON f.id = q.id WHERE q.revatureQuestion=true")
	public List<Faq> getFaqByRevQuestion();

	@Query(value="SELECT TOP 1 * FROM Questions ORDER BY ID DESC", nativeQuery=true)
	public int getQuestionID();
	
	@Query(value="SELECT TOP 1 * FROM Answers ORDER BY ID DESC", nativeQuery=true)
	public int getAnswerID();

	@Transactional
	@Modifying
	@Query(value="Update Answers a set question_id= ?1 where a.id= ?2", nativeQuery=true)
	public int updateQuestionID(int questionId, int answerId);

}
