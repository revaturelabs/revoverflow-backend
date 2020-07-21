package com.revature.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.controller.QuestionController;
import com.revature.entities.Question;
import com.revature.services.QuestionService;


@RunWith(SpringRunner.class)
@WebMvcTest(QuestionController.class)
public class QuestionControllerTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private QuestionService questionService;
	
	@Test
	public void testGetAllQuestionsHappyPath() throws Exception {
		
		// Create page of data
		List<Question> questions = new ArrayList<>();
		questions.add(new Question(1,1,"title","content", LocalDate.MIN, LocalDate.MIN, true, 1));
		Page<Question> pageResult = new PageImpl<>(questions);
		
		// Stub getAllQuestions to return page of data
		when(questionService.getAllQuestions(Mockito.any(Pageable.class))).thenReturn(pageResult);
		
		// Call API end point and assert result
		mvc.perform(get("/questions")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.content[0].title", is("title")));
			
	}
	
	/* @Author ken */
	@Test
	public void testGetAllQuestionsByUserId() throws Exception {
		// Create page of data
		List<Question> questions = new ArrayList<>();
		questions.add(new Question(1,1,"title","content", LocalDate.MIN, LocalDate.MIN, true, 1));
		Page<Question> pageResult = new PageImpl<>(questions);
		
		// Stub getAllQuestions to return page of data
		when(questionService.getAllQuestionsByUserId(Mockito.any(Pageable.class), Mockito.anyInt())).thenReturn(pageResult);
		
		// Call API end point and assert result
		mvc.perform(get("/questions/user/1")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.content[0].id", is(1)));
			
	}
	
	/* @Author ken 	*/
	@Test
	public void testGetAllQuestionsByStatus() throws Exception {
		
		// Create page of data
		List<Question> questions = new ArrayList<>();
		questions.add(new Question(1,1,"title", "content", LocalDate.MIN, LocalDate.MIN, false, 1));
		Page<Question> pageResult = new PageImpl<>(questions);
		
		// Stub getAllQuestions to return page of data
		when(questionService.getAllQuestionsByStatus(Mockito.any(Pageable.class), Mockito.anyBoolean())).thenReturn(pageResult);
		
		// Call API end point and assert result
		mvc.perform(get("/questions/status/false")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.content[0].id", is(1)));
			
	}

	
	/* @Author Natasha Poser */
	@Test
	public void testGetQuestionById() throws Exception {
		// Create page of data
		List<Question> questions = new ArrayList<>();
		questions.add(new Question(1,1,"title","content", LocalDate.MIN, LocalDate.MIN, true, 1));
		Page<Question> pageResult = new PageImpl<>(questions);
		
		// Stub getAllQuestions to return page of data
		when(questionService.getQuestionById(Mockito.any(Pageable.class), Mockito.anyInt())).thenReturn(pageResult);
		
		// Call API end point and assert result
		mvc.perform(get("/questions/id/1")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.content[0].id", is(1)));
			
	}
		
}
