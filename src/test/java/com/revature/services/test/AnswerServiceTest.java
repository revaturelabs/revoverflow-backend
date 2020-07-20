package com.revature.services.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.h2.result.ResultRemote;
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

import com.revature.entities.Answer;
import com.revature.repositories.AnswerRepository;
import com.revature.services.AnswerService;

@RunWith(SpringRunner.class)
@WebMvcTest(AnswerService.class)
public class AnswerServiceTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	AnswerService answerService;

	@Test
	public void getAllAnswersTest() throws Exception {
		
		Answer answer = new Answer(1, 1, 1, "test content", LocalDate.MIN, LocalDate.MIN);	
		List<Answer> answers = new ArrayList<>();	
		answers.add(answer);	

		Page<Answer> pageResult = new PageImpl<Answer>(answers);	

		when(answerService.getAnswers(Mockito.any(Pageable.class))).thenReturn((pageResult));	

		this.mvc.perform(get("/answers")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.content[0].id", is(1)));
		
		//Page<Answer> result = answerService.getAnswers(Mockito.any(Pageable.class));
		System.out.println("what is the result = " + pageResult);
		//assertEquals(page, answer);
		//assertEquals(pageResult, answer);
		assertThat(pageResult).contains(answer);	
		//assertEquals( pageResult, result);
		
	}
	

}
