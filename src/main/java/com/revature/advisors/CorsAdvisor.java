package com.revature.advisors;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@ControllerAdvice
@CrossOrigin(
	origins = { "http://localhost:3000" }, 
	methods = { RequestMethod.GET, RequestMethod.PUT, 
				RequestMethod.PATCH, RequestMethod.POST },
	allowedHeaders = { "content-type" }
)
public class CorsAdvisor {
	
}
