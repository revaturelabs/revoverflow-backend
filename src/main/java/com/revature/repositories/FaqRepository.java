package com.revature.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.entities.Faq;


@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer>{

	public List<Faq> findAll();
	
	@Query("From Faq f INNER JOIN Location l ON f.locationId = l.id WHERE :location = l.locationName")
	public List<Faq> getFaqByLocation(String location);

}
