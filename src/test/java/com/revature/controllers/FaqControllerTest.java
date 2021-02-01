package com.revature.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Application;
import com.revature.entities.Answer;
import com.revature.entities.Faq;
import com.revature.entities.Question;
import com.revature.entities.User;
import com.revature.services.FaqService;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = Application.class)
@AutoConfigureMockMvc
public class FaqControllerTest {
	
	@Autowired 
	private ObjectMapper mapper;
	
	@Autowired
	private WebApplicationContext context;

	static User u1;
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private FaqService faqService;
	
	@Before                          
    public void setUp() {  
       u1 = new User(12,26,0,true,null,"admin@rss.com","Admin","Admin", "password");
   	   mvc = MockMvcBuilders
   				.webAppContextSetup(context)
   				.apply(springSecurity())
   				.build();
    }
	
	@Test
    @WithMockUser(username = "admin@rss.com", password = "Password123!", authorities = "admin")
	public void testGetAllFaq() throws Exception {
		
		List<Faq> faqList = new ArrayList<>();
		
		Question q = new Question();
		q.setId(1);
		
		Answer a = new Answer();
		a.setId(1);
		
		faqList.add(new Faq(6,q,a,"Toronto"));

		// Stub getAllQuestions to return page of data
		when(faqService.getAllFaq()).thenReturn(faqList);
		
		// Call API end point and assert result
		MvcResult result = mvc.perform(get("/faq/all")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].faqId", is(6))).andReturn();
		System.out.println("Result testGetAllFaq : "+result.getResponse().getContentAsString());
        assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
    @WithMockUser(username = "admin@rss.com", password = "Password123!", authorities = "admin")
	public void testGetFaqByLocation() throws Exception {
		
		List<Faq> faqList = new ArrayList<>();
		
		Question q = new Question();
		q.setId(1);
		
		Answer a = new Answer();
		a.setId(1);
		
		faqList.add(new Faq(6,q,a,"Toronto"));

		// Stub getAllQuestions to return page of data
		when(faqService.getFaqByLocation("Toronto")).thenReturn(faqList);
		
		// Call API end point and assert result
		MvcResult result = mvc.perform(get("/faq/Toronto")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[0].location", is("Toronto"))).andReturn();
		System.out.println("Result testGetFaqByLocation : "+result.getResponse().getContentAsString());
        assertEquals(200, result.getResponse().getStatus());
	}
}


