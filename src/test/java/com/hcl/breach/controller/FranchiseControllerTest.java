package com.hcl.breach.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.breach.service.BusinessAreaService;
import com.hcl.breach.service.FranchiseService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class FranchiseControllerTest {
	
	@Mock
	FranchiseService franchiseService;
	@Mock
	BusinessAreaService businessAreaService;
	@InjectMocks
	FranchiseController franchiseController;
	
	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(franchiseController).build();
	}

	@Test
	public void getAllFranchise() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/franchises").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@Test
	public void getAllBusinessAreas() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/businessAreas/{franchiseId}",1).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
