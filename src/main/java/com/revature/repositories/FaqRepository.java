package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.entities.Faq;


@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer>{

	//@Query("select faq.faq_id, questions.content, answers.content from faq inner join questions on faq.question_id=questions.id inner join answers on questions.id=answers.question_id")
	public List<Faq> findAll();
	
	@Query("from Faq f where f.location=?1")
	public List<Faq> getFaqByLocation(String location);
	
}
