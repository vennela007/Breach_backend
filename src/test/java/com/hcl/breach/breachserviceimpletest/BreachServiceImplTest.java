package com.hcl.breach.breachserviceimpletest;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.breach.dto.BreachRequestDto;
import com.hcl.breach.dto.BreachResponseDto;
import com.hcl.breach.entity.Breach;
import com.hcl.breach.entity.RiskProfile;
import com.hcl.breach.repository.BreachRepository;
import com.hcl.breach.repository.RiskProfileRepository;
import com.hcl.breach.service.BreachServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BreachServiceImplTest {

	@Mock
	BreachRepository breachRepository;

	@Mock
	RiskProfileRepository riskProfileRepository;

	@InjectMocks
	BreachServiceImpl breachServiceImpl;
	
	Breach breach;
	BreachRequestDto breachRequestDto;
	RiskProfile riskProfile;
	
	@Before
	public void setUp() {
		breach=getBreach();
		breachRequestDto=getBreachRequestDto();
		riskProfile=getRiskProfile();
	}

	@Test()
	public void createBreachTest()
	{
		Mockito.when(riskProfileRepository.findByFranchiseAndBusinessAreaAndBreachCategory(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(Optional.of(riskProfile));
		Mockito.when(breachRepository.save(Mockito.any())).thenReturn(breach);
		BreachResponseDto actual = breachServiceImpl.createBreach(breachRequestDto);
		Assert.assertEquals("Breach created successfully", actual.getMessage());
		
		
	}

	public Breach getBreach() {
		return new Breach(1, "Loss of device", "Risk", "RBSI", "hello", "P", "H", LocalDate.now(), 1);
	}
	
	public BreachRequestDto getBreachRequestDto()
	{
		return new BreachRequestDto("Loss of device", "Risk", "RBSI", "credit card loss", 1);
	}
	
	public RiskProfile getRiskProfile()
	{
		return new RiskProfile(1, "Loss of device", "Risk", "RBSI", "H");
	}

}
