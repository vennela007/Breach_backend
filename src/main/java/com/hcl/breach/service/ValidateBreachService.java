/**
 * 
 */
package com.hcl.breach.service;

import org.springframework.stereotype.Service;

import com.hcl.breach.dto.ValidateBreachRequestDto;
import com.hcl.breach.dto.ValidateBreachResponseDto;

/**
 * @author Gurpreet Singh
 *
 */
@Service
public interface ValidateBreachService {

	public ValidateBreachResponseDto validateBreach(ValidateBreachRequestDto validateBreachRequestDto);
	
}
