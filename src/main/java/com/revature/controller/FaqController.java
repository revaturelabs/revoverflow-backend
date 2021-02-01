package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Faq;
import com.revature.services.FaqService;

@RestController
@RequestMapping("/faq")
public class FaqController {
	
	@Autowired
	FaqService faqService;
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('admin')")
	public List<Faq> getAllFaq(){
		return faqService.getAllFaq();
	}
	
	@GetMapping("/{location}")
	@PreAuthorize("hasAuthority('admin')")
	public List<Faq> getFaqByLocation(@PathVariable String location){
		return faqService.getFaqByLocation(location);
	}

}
