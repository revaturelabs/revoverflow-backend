package com.revature.controllers.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.controller.AnswerController;
import com.revature.entities.Answer;
import com.revature.services.AnswerService;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerController.class)
public class AnswerControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private AnswerService answerService;
	
	@Test
	public void test() {
		System.out.println("I am testing the AnswerControllerTest");
	}
	
	/**@author ken*/
	@Test
	public void testGetAnswers() throws Exception{
		List<Answer> answers = new ArrayList<Answer>();
		answers.add(new Answer(1, 1, 1, "Test content", LocalDate.MIN, LocalDate.MIN));
		Page<Answer> pageResult = new PageImpl<>(answers);
		
		when(answerService.getAnswers(Mockito.any(Pageable.class))).thenReturn(pageResult);
		
		mvc.perform(get("/answers")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
				//.andExpect(jsonPath("$.content[0].userId", is("userId")));
	}
	
	@Test
	public void testSaveAnswer() throws Exception {
		Answer answer = new Answer(1, 1, 1, "test content", LocalDate.MIN, LocalDate.MIN);
		
		mvc.perform(post("/answers")
				.accept(MediaType.APPLICATION_JSON));
				//.andExpect(status().isOk());
				//.andExpect(content()
				//		.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
				//.andExpect(jsonPath("$.content[0].userId", is("userId")));

	}
	
}
