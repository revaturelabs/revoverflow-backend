package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.revature.entities.Answer;
import com.revature.entities.Faq;
import com.revature.entities.Question;
import com.revature.repositories.FaqRepository;

@Service
public class FaqService {
	
	@Autowired
	FaqRepository faqRepo;

	
	public List<Faq> getAllFaq(){
		return faqRepo.findAll();
	}
	
	public List<Faq> getFaqByLocation(String location){
		return faqRepo.getFaqByLocation(location);
	}

	public Faq save(Faq faq) {
		return faqRepo.saveAndFlush(faq);
	}


	
}
