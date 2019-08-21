/**
 * 
 */
package com.hcl.breach.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.breach.dto.ValidateBreachRequestDto;
import com.hcl.breach.dto.ValidateBreachResponseDto;
import com.hcl.breach.repository.BreachRepository;
import com.hcl.breach.service.ValidateBreachServiceImpl;

/**
 * @author user1
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidateBreachControllerTest {
	
	private MockMvc mockMvc;

	@InjectMocks
	ValidateBreachController validateBreachController;
	
	@Mock
	ValidateBreachServiceImpl validateBreachServiceImpl;
	
	@Mock
	BreachRepository breachRepository;
	
	ValidateBreachResponseDto validateBreachResponseDto;
	ValidateBreachRequestDto validateBreachRequestDto; 
	
	public ValidateBreachResponseDto getValidateBreachResponseDto()
	{
		validateBreachResponseDto = new ValidateBreachResponseDto();
		validateBreachResponseDto.setMessage("the breach is");
		return validateBreachResponseDto;
	}
	
	public ValidateBreachRequestDto getValidateBreachRequestDto()
	{
		validateBreachRequestDto = new ValidateBreachRequestDto();
		validateBreachRequestDto.setBreachId(1);
		validateBreachRequestDto.setStatus("C");
		return validateBreachRequestDto;
	}
	@Before
	public void setup()
	{
		mockMvc = MockMvcBuilders.standaloneSetup(validateBreachController).build();
	}
	
	@Test
	public void testVaildateBreach() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.put("/api/action").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(getValidateBreachResponseDto()))).andExpect(MockMvcResultMatchers.status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
