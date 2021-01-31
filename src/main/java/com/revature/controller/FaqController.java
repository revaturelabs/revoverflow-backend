package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Faq;
import com.revature.services.FaqService;

@RestController
@RequestMapping("/faq")
public class FaqController {
	
	@Autowired
	FaqService faqService;
	
	@GetMapping
	@PreAuthorize("hasAuthority('admin')")
	public List<Faq> getAllFaq(){
		return faqService.getAllFaq();
	}
	
	@GetMapping("/{location}")
	@PreAuthorize("hasAuthority('admin')")
	public List<Faq> getFaqByLocation(@PathVariable String location){
		return faqService.getFaqByLocation(location);
	}
	
	@GetMapping("/revature/question")
	@PreAuthorize("hasAuthority('admin')")
	public List<Faq> getFaqByRevQuestion(){
		return faqService.getFaqByRevQuestion();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('admin')")
	public Faq saveQuestion(@RequestBody Faq faq) {
		return faqService.save(faq);
	}

}
