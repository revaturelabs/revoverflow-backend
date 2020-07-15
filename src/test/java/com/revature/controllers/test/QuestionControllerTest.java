package com.revature.controllers.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.revature.entities.Question;
import com.revature.repositories.QuestionRepository;
import com.revature.services.QuestionService;


public class QuestionControllerTest {
	
	QuestionRepository questionRepository = Mockito.mock(QuestionRepository.class);
	QuestionService questionService = new QuestionService(questionRepository);
	
	
	/** @author ken */
	@Test
	public void saveQuestion(){
		LocalDate creationDate = LocalDate.now();
		LocalDate editDate = LocalDate.now();
		Question question = new Question(1, 1, "testStuff", "test content", creationDate, editDate, false, 1);
		when(questionService.save(question)).thenReturn(question);
		
		Question result = questionService.save(question); 
		assertEquals(question, result);
	}
	
	/** @author ken */
	@Test
	public void getAllQuestions() {
		Question question = new Question();
		List<Question> questions = new ArrayList<>();
	
		Page<Question> page = new PageImpl<Question>(questions);
		Pageable pageable = new Pageable() {
			
			@Override
			public Pageable previousOrFirst() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Pageable next() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Sort getSort() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getPageSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getPageNumber() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getOffset() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Pageable first() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		when(questionService.getAllQuestions(pageable)).thenReturn((page));
		Page<Question> result = questionService.getAllQuestions(pageable);
		assertEquals(page, result);
	}
}
