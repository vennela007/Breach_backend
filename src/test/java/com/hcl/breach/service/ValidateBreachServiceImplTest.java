/**
 * 
 */
package com.hcl.breach.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.breach.dto.ValidateBreachRequestDto;
import com.hcl.breach.dto.ValidateBreachResponseDto;
import com.hcl.breach.entity.Breach;
import com.hcl.breach.exception.BreachNotFoundException;
import com.hcl.breach.repository.BreachRepository;

/**
 * @author user1
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidateBreachServiceImplTest {
	
	@InjectMocks 
	ValidateBreachServiceImpl validateBreachServiceImpl;
	
	@Mock
	BreachRepository breachRepository;
	
	ValidateBreachRequestDto validateBreachRequestDto;
	ValidateBreachResponseDto validateBreachResponseDto;
	Breach breach;
	
	@Before
	public void setup()
	{
		validateBreachRequestDto = new ValidateBreachRequestDto();
		validateBreachResponseDto = new ValidateBreachResponseDto();
		breach = new Breach();
	}
	
	public Breach getBreach() {

		Breach breach = new Breach();
		breach.setBreachId(1);
		breach.setStatus("C");
		return breach;
	}
	
	public ValidateBreachRequestDto getValidateBreachRequestDto()
	{
		ValidateBreachRequestDto validateBreachRequestDto = new ValidateBreachRequestDto();
		validateBreachRequestDto.setBreachId(1);
		validateBreachRequestDto.setStatus("P");
		return validateBreachRequestDto;
	}
	
	public ValidateBreachResponseDto getValidateBreachResponseDto()
	{
		ValidateBreachResponseDto validateBreachResponseDto = new ValidateBreachResponseDto();
		validateBreachResponseDto.setMessage("The breach is");
		return validateBreachResponseDto;
	}
	
	@Test
	public void testvalidateBreach()
	{
		Mockito.when(breachRepository.findById(validateBreachRequestDto.getBreachId())).thenReturn(Optional.of(breach));
		Mockito.when(breachRepository.save(Mockito.any())).thenReturn(breach);
		ValidateBreachResponseDto actual = validateBreachServiceImpl.validateBreach(getValidateBreachRequestDto());
		assertEquals("The breach is closed", actual.getMessage());
	}
	
	@Test(expected = BreachNotFoundException.class)
	public void testvalidateBreachNoBreach() {
		breach.setBreachId(1);
		validateBreachServiceImpl.validateBreach(getValidateBreachRequestDto());
	}
	
	@Test(expected = BreachNotFoundException.class)
	public void testvalidateBreachNoBreachFound() {
		breach.setBreachId(1);
		breach.setStatus("P");
		Mockito.when(breachRepository.findById(validateBreachRequestDto.getBreachId())).thenReturn(Optional.of(breach));
		validateBreachServiceImpl.validateBreach(getValidateBreachRequestDto());
	}
}
