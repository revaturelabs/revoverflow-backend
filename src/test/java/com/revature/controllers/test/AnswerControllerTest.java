package com.revature.controllers.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.net.HttpHeaders;
import com.revature.controller.AnswerController;
import com.revature.entities.Answer;
import com.revature.services.AnswerService;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerController.class)
public class AnswerControllerTest {
	
	@Autowired
    private ObjectMapper mapper;
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private AnswerService answerService;
	
	/**@author ken*/
	@Test
	public void testGetAnswers() throws Exception{
		List<Answer> answers = new ArrayList<>();
		answers.add(new Answer(1, 1, 1, "Test content", LocalDate.MIN, LocalDate.MIN));
		Page<Answer> pageResult = new PageImpl<>(answers);
		
		when(answerService.getAnswers(Mockito.any(Pageable.class))).thenReturn(pageResult);
		
		mvc.perform(get("/answers")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.content[0].id", is(1)));
	}
	
	/** @author ken */
	@Test
	public void testSaveAnswer() throws Exception {
		Answer answer = new Answer(1, 1, 1, "test content", LocalDate.MIN, LocalDate.MIN);

		when(answerService.save(Mockito.any(Answer.class))).thenReturn(answer);
		
        String toUpdate = mapper.writeValueAsString(answer);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(toUpdate)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                ).andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println("result = " + content);
        assertEquals(200, result.getResponse().getStatus());
        assertTrue("This return object conains the string", content.contains("test content"));
        assertNotEquals(null, content);
	}
	
	
	/**@author ken*/
	@Test
	public void testGetAnswerByUserId() throws Exception {
		List<Answer> answers = new ArrayList<>();
		answers.add(new Answer(1, 1, 1, "Test content", LocalDate.MIN, LocalDate.MIN));
		Page<Answer> pageResult = new PageImpl<>(answers);
		
		when(answerService.getAllAnswersByUserID(Mockito.any(Pageable.class), Mockito.anyInt())).thenReturn(pageResult);
		
		mvc.perform(get("/answers/user/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.content[0].id", is(1)));
	}
	
	/** @author Natasha Poser */
	@Test
	public void testGetAnswerByQuestionId() throws Exception {
		List<Answer> answers = new ArrayList<>();
		answers.add(new Answer(1, 1, 1, "Test content", LocalDate.MIN, LocalDate.MIN));
		Page<Answer> pageResult = new PageImpl<>(answers);
		
		when(answerService.getAnswerByQuestionId(Mockito.any(Pageable.class), Mockito.anyInt())).thenReturn(pageResult);
		
		mvc.perform(get("/answers/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.content[0].id", is(1)));
	}
	
	/** @author Natasha Poser */
	@Test
	public void testGetAcceptedAnswerByQuestionId() throws Exception {
		List<Answer> answers = new ArrayList<>();
		answers.add(new Answer(1, 1, 1, "Test content", LocalDate.MIN, LocalDate.MIN));
		Page<Answer> pageResult = new PageImpl<>(answers);
		
		when(answerService.getAcceptedAnswerByQuestionId(Mockito.any(Pageable.class), Mockito.anyInt())).thenReturn(pageResult);
		
		mvc.perform(get("/answers/acceptedAnswers/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.content[0].id", is(1)));
	}
	/** @author Natasha Poser */
	@Test
	public void testGetAnswerById() throws Exception {
		List<Answer> answers = new ArrayList<>();
		answers.add(new Answer(1, 1, 1, "Test content", LocalDate.MIN, LocalDate.MIN));
		Page<Answer> pageResult = new PageImpl<>(answers);
		
		when(answerService.getAnswerById(Mockito.any(Pageable.class), Mockito.anyInt())).thenReturn(pageResult);
		
		mvc.perform(get("/answers/id/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.content[0].id", is(1)));
	} 
	
}
