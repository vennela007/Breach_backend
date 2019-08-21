package com.hcl.breach.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.breach.dto.UserLoginRequestDto;
import com.hcl.breach.service.LoginServiceImpl;
import com.hcl.breach.service.LoginServiceTest;

/**
this class is for testing Login Service class methods
 **/
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class LoginControllerTest {

	MockMvc mockMvc;

	@InjectMocks
	LoginController loginController;
	
	@Mock
	LoginServiceImpl LoginServiceImpl;
	private static Logger logger = LoggerFactory.getLogger(LoginServiceTest.class);
	@Before
	public void setup()
	{
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}
	
	@Test
	public void loginUserTest() throws Exception{
		
		logger.info("inside the loginUserTest controller method ");
		UserLoginRequestDto userLoginRequestDto = new UserLoginRequestDto();
		userLoginRequestDto.setUserName("venkat");
		userLoginRequestDto.setPassword("password");
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/userLogin")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(userLoginRequestDto))).andExpect(MockMvcResultMatchers.status().isOk());
				
		
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
