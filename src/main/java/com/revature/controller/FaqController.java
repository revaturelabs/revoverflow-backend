package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Faq;
import com.revature.services.FaqService;


/**
 * @authors Mahesh Kalle & Jeevan Selvagunarajah
 *
 */

@RestController
@RequestMapping("/faq")
public class FaqController {
	
	@Autowired
	FaqService faqService;

	
	/**
	 * @return all frequently asked questions
	 */
	@GetMapping
	@PreAuthorize("hasAuthority('admin')")
	public List<Faq> getAllFaq(){
		return faqService.getAllFaq();
	}
	
	/**
	 * @param takes in the faq id
	 * @return returns the Faq object associated with the id
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('admin')")
	public Faq findFaqById(@PathVariable int id) {
		return faqService.findFaqById(id);
	}
	
	/**
	 * @return returns all Revature based frequently asked questions
	 */
	@GetMapping("/revature")
	@PreAuthorize("hasAuthority('admin')")
	public List<Faq> getFaqByRevQuestion(){
		return faqService.getRevatureBasedFaq();
	}
	
	
	/**
	 * @param takes in the location name
	 * @return returns all frequently asked questions 
	 * filtered by location name 
	 */
	@GetMapping("/location/{name}")
	@PreAuthorize("hasAuthority('admin')")
	public List<Faq> getFaqByLocation(@PathVariable String name){
		return faqService.getFaqByLocation(name);
	}
	
	
	/**
	 * @param location takes in the name of the location
	 * @return returns all frequently asked questions that are 
	 * Revature based filtered by the location name 
	 */
	@GetMapping("/revature/{location}")
	@PreAuthorize("hasAuthority('admin')")
	public List<Faq> getRevatureAndLocationFaq(@PathVariable String location){
		return faqService.getRevatureAndLocationFaq(location);
	}
	
	
	
	/**
	 * @param takes in Faq object
	 * @return returns the Faq object stored in the database
	 */
	@PostMapping
	@PreAuthorize("hasAuthority('admin')")
	public Faq addNewFaq(@RequestBody Faq newFaq){
		return faqService.newFaqQuestion(newFaq);
	}
	
	
	/**
	 * @param takes in the Faq id and deletes the respective
	 * Faq object in the database
	 */
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('admin')")
	public void deleteFaqById(@PathVariable int id) {
		faqService.deleteFaqById(id);
	}


	
	/**
	 * @param takes in the updated Faq object 
	 * @return returns the object that is stored in the database
	 */
	@PutMapping
	@PreAuthorize("hasAuthority('admin')")
	public Faq UpdateFaqById( @RequestBody Faq faq) {
		return faqService.updateFaq(faq);
	}
	
	
}
