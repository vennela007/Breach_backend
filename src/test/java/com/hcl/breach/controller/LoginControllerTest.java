/*package com.hcl.breach.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.breach.dto.UserLoginRequestDto;
import com.hcl.breach.service.LoginServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginControllerTest.class)
public class LoginControllerTest {

	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	LoginServiceImpl LoginServiceImpl;
	
	@Test
	public void loginUserTest() {
		UserLoginRequestDto userLoginRequestDto = new UserLoginRequestDto();
		userLoginRequestDto.setUserName("venkat");
		userLoginRequestDto.setPassword("password");
		mockMvc.perform(MockMvcRequestBuilders.post("/api/userLogin").contentType(MediaType.APPLICATION_JSON)
				.content((asJsonString(userLoginRequestDto))).expect(MockMvcResultMatchers.status().isOk()));
		
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
*/