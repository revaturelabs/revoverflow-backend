package com.revature.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Answer;
import com.revature.entities.Faq;
import com.revature.entities.Location;
import com.revature.entities.Question;
import com.revature.repositories.AnswerRepository;
import com.revature.repositories.FaqRepository;
import com.revature.repositories.LocationRepository;
import com.revature.repositories.QuestionRepository;

@Service
public class FaqService {

	@Autowired
	FaqRepository faqRepository;
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	LocationRepository locationRepository;

	public List<Faq> getAllFaq() {
		return faqRepository.findAll();
	}


	public List<Faq> getFaqByLocation(String location) {
		Location faqLocation = this.getLocation(location);
		return faqRepository.getFaqByLocation(faqLocation.getId());
	}

	public List<Faq> getRevatureAndLocationFaq(String location) {
		Location faqLocation = this.getLocation(location);
		return faqRepository.getRevatureAndLocationFaq(faqLocation.getId());
	}
		

	public List<Faq> getRevatureBasedFaq() {
		return faqRepository.getRevatureBasedFaq();
	}


	@Transactional
	public Faq newFaqQuestion(Faq faq) {
		Question question = this.saveFaqQuestion(faq.getQuestion());
		Answer answer = faq.getAnswer();
		answer.setQuestionId(question.getId());
		Answer savedAnswer = this.saveFaqAnswer(answer);
		Faq submitfaq = new Faq(question,savedAnswer);
		Faq newFaq = faqRepository.save(submitfaq);
		return newFaq;
	}

	
	public Location getLocation(String location) {
		Location faqLocation = locationRepository.findByLocationName(location);
		return faqLocation;
	}

	public Question saveFaqQuestion(Question question) {
		question.setCreationDate(LocalDateTime.now());
		question.setEditDate(LocalDateTime.now());
		Question faqQuestion = questionRepository.save(question);
		return faqQuestion;
	}

	public Answer saveFaqAnswer(Answer answer) {
		answer.setCreationDate(LocalDateTime.now());
		answer.setEditDate(LocalDateTime.now());
		Answer faqAnswer = answerRepository.save(answer);
		return faqAnswer;
	}
	
	public void deleteFaqById(int id) {
		faqRepository.deleteById(id);
	}
	
	public Faq findFaqById(int id) {
		Optional<Faq> faq = faqRepository.findById(id);
		if(faq.isPresent()) {
			return faq.get();
		}
		else return null;
		}
		
	public Faq updateFaq(Faq faq) {
		Faq updatedFaq = faqRepository.save(faq);
			return updatedFaq;	
	}
	
}
