package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.revature.entities.User;
import com.revature.util.JwtUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JwtUtilTest {
	static User u1;
	@Autowired
    private MockMvc mvc;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Before
	public void setup() {
		u1 = new User(12,26,0,true,null,"admin@rss.com","Admin","Admin");
	}
	@Test
    public void shouldGenerateAuthToken() throws Exception {
        String token = jwtUtil.generateToken(u1);
        System.out.println(token);
        assertNotNull(token);
    }
	@Test
    public void shouldGenerateAuthTokenAndBeAuthenticatedToRetreiveUser12() throws Exception {
        String token = jwtUtil.generateToken(u1);
        assertNotNull(token);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/user/12").header("Authorization", "Bearer " + token)).andReturn();
        String content = result.getResponse().getContentAsString();
        //System.out.println(content + "\n" + result.getResponse().getStatus());
        assertEquals(200, result.getResponse().getStatus());
        assertNotNull(content);
    }
	@Test
    public void shouldGenerateAuthTokenAndReturn_403_UnauthorizedDueToNoBearerInToken() throws Exception {
        String token = jwtUtil.generateToken(u1);
        assertNotNull(token);
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/user/12").header("Authorization", token)).andReturn();
        assertEquals(403, result.getResponse().getStatus());
    }
	

}
