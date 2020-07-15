package com.revature.controllers.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Test;
import org.mockito.Mockito;

import com.revature.entities.Question;
import com.revature.repositories.QuestionRepository;
import com.revature.services.QuestionService;

public class QuestionControllerTest {
	
	QuestionRepository questionRepository = Mockito.mock(QuestionRepository.class);
	QuestionService questionService = new QuestionService(questionRepository);
	
	@Test
	public void test() {
		System.out.println("I am in the test");
	}
	
	/** @author ken */
	@Test
	public void saveAnswer(){
		LocalDate creationDate = LocalDate.now();
		LocalDate editDate = LocalDate.now();
		Question question = new Question(1, 1, "testStuff", "test content", creationDate, editDate, false, 1);
		when(questionService.save(question)).thenReturn(question);
		
		Question result = questionService.save(question); 
		assertEquals(question, result);
	}
}
