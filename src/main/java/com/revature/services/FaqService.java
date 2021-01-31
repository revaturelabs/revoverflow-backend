package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Faq;
import com.revature.repositories.FaqRepository;

@Service
public class FaqService {
	
	@Autowired
	FaqRepository faqRepository;

	
	public List<Faq> getAllFaq(){
		return faqRepository.findAll();
	}
	
	public List<Faq> getFaqByLocation(String location){
		return faqRepository.getFaqByLocation(location);
	}

	public Faq save(Faq faq) {
		faqRepository.save(faq);
		int questionId = faqRepository.getQuestionID();
		int answerId = faqRepository.getAnswerID();
		faqRepository.updateQuestionID(questionId, answerId);
		return faq;
	}

	public List<Faq> getFaqByRevQuestion() {
		return faqRepository.getFaqByRevQuestion();
	}

}
