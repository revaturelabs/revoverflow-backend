package com.revature.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.DisabledIf;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Location;
import com.revature.entities.Question;
import com.revature.repositories.QuestionRepository;

import io.jsonwebtoken.lang.Arrays;

public class QuestionServiceTest {

	@Mock
	QuestionRepository questionRepository;
	
	@InjectMocks
	QuestionService questionService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);	
	}
	
	/**@author Arjun/Hassen*/
	@Test
	public void getQuestionsBasedOnRevatureWillReturnRevaturBaseQuestion() {
	
		Question q1 = new Question(1,1,"title","content", LocalDateTime.MIN, LocalDateTime.MIN, true, true, 1, 0);
		Question q2 = new Question(2,1,"title","content", LocalDateTime.MIN, LocalDateTime.MIN, true, false, 1, 0);
		
		List<Question> questions = Lists.newArrayList(q1, q2);
		
		Page<Question> pageResult = new PageImpl<Question>(questions);
		
		Mockito.when(questionRepository.getQuestionsBasedOnRevature(Mockito.any(Pageable.class), Mockito.anyBoolean())).thenReturn(pageResult);
		Page<Question> result = questionService.getQuestionsBasedOnRevature(PageRequest.of(1, 2), false);
				
		System.out.println(result.getNumberOfElements());
		assertEquals(result, pageResult);
	}
	
	
	
	
//	@Test
//	@Disabled("Disabled until it is known how to use jUnit with Pages")
//	/**@Author Hammad*/
//	public void testGetAllQuestionsByLocationID() {
//		
//		List<Question> expectedResult = new ArrayList<Question>();
//		Question q1 = new Question(1, 1, "title", "content", LocalDateTime.MIN, LocalDateTime.MIN, true, false, 1,2);
//		Question q2 = new Question(1, 1, "title", "content", LocalDateTime.MIN, LocalDateTime.MIN, true, false, 1,2);
//		expectedResult.add(q1);
//		expectedResult.add(q2);
//		
//		Page<Question> expectedResultPage = new PageImpl<Question>(expectedResult); //, Mockito.any(Pageable.class), 1
//
//		Mockito.when(questionRepository.findByLocationID(Mockito.any(Pageable.class), 2)).thenReturn(expectedResultPage);
//		
//		Page<Question> actualResultPage = questionService.getAllQuestionsByLocationID(Mockito.any(Pageable.class), 2);
//		assertEquals(expectedResultPage, actualResultPage);
//	}
	
	@Test
	public void updateQuestionAcceptedAnswerId_will_return_question() {
		Question q = new Question(1, 1, "title", "content", LocalDateTime.MIN, LocalDateTime.MIN, true, false, 1,1);
		Question q1 = new Question(1, 1, "title", "content", LocalDateTime.MIN, LocalDateTime.MIN, true, false, 1,1);
		Mockito.when(questionRepository.save(q)).thenReturn(q1);
		
		Question q2 = questionService.updateQuestionAcceptedAnswerId(q);
		//System.out.println(q2);
		
		assertEquals(q1,q2);
	}
	
	@Test(expected = HttpClientErrorException.class)
	public void updateQuestionAcceptedAnswerId_will_return_bad_request() {
		//Intentional send question with id = 0
		Question q2 = new Question(0,1,"title","content", LocalDateTime.MIN, LocalDateTime.MIN, true, false, 1,0);
		Mockito.when(questionRepository.save(Mockito.any(Question.class))).thenReturn(null);
		
		Question q3 = questionService.updateQuestionAcceptedAnswerId(q2);
		//System.out.println(q3);
		
	}
}
