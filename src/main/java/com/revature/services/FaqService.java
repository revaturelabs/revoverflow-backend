package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Faq;
import com.revature.repositories.FaqRepository;

@Service
public class FaqService {
	
	@Autowired
	FaqRepository faqRepo;

	
	public List<Faq> getAllFaq(){
		System.out.println("In Service Class getAllFaq: "+faqRepo.findAll());
		return faqRepo.findAll();
	}
	
	public List<Faq> getFaqByLocation(String location){
		System.out.println("In Service Class getFaqByLocation: "+location);
		return faqRepo.getFaqByLocation(location);
	}
	
}
