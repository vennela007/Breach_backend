/**
 * 
 */
package com.hcl.breach.service;

import org.springframework.stereotype.Service;

import com.hcl.breach.dto.ValidateBreachRequestDto;
import com.hcl.breach.dto.ValidateBreachResponseDto;

/**
 * @author user1
 *
 */
@Service
public interface ValidateBreachService {

	public ValidateBreachResponseDto validateBreach(ValidateBreachRequestDto validateBreachRequestDto);
	
}
