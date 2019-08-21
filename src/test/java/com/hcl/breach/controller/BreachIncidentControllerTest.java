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
import com.hcl.breach.service.BreachIncidentService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class BreachIncidentControllerTest {

	@Mock
	BreachIncidentService breachIncidentService;
	@InjectMocks
	BreachIncidentController breachIncidentController;
	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(breachIncidentController).build();
	}

	@Test
	public void getAllBreachIncidents() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/breaches/{role}", "H").contentType(MediaType.APPLICATION_JSON)
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
