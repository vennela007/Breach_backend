package com.hcl.breach.controllertest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

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
import com.hcl.breach.controller.BreachController;
import com.hcl.breach.dto.BreachRequestDto;
import com.hcl.breach.entity.Breach;
import com.hcl.breach.entity.RiskProfile;
import com.hcl.breach.service.BreachService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class BreachControlerTests {

	@Mock
	BreachService breachService;

	@InjectMocks
	BreachController breachController;

	MockMvc mockMvc;
	Breach breach;
	BreachRequestDto breachRequestDto;
	RiskProfile riskProfile;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(breachController).build();
		breach=getBreach();
		breachRequestDto=getBreachRequestDto();
		riskProfile=getRiskProfile();
	}

	@Test
	public void createBreachTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/createBreach").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(breachRequestDto))).andExpect(status().isCreated());

	}

	public Breach getBreach() {
		return new Breach(1, "Loss of device", "Risk", "RBSI", "hello", "P", "H", LocalDate.now(), 1);
	}

	public BreachRequestDto getBreachRequestDto() {
		return new BreachRequestDto("Loss of device", "Risk", "RBSI", "credit card loss", 1);
	}

	public RiskProfile getRiskProfile() {
		return new RiskProfile(1, "Loss of device", "Risk", "RBSI", "H");
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
