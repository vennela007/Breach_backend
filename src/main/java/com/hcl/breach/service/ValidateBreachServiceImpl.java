/**
 * 
 */
package com.hcl.breach.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.dto.ValidateBreachRequestDto;
import com.hcl.breach.dto.ValidateBreachResponseDto;
import com.hcl.breach.entity.Breach;
import com.hcl.breach.exception.BreachNotFoundException;
import com.hcl.breach.repository.BreachRepository;

/**
 * @author user1
 *
 */
@Service
public class ValidateBreachServiceImpl implements ValidateBreachService{
	
	@Autowired
	BreachRepository breachRepository;

	/**
	 * This method is use to provide validation for each breach 
	 */
	@Override
	public ValidateBreachResponseDto validateBreach(ValidateBreachRequestDto validateBreachRequestDto) {

		Optional<Breach> breach = breachRepository.findById(validateBreachRequestDto.getBreachId());
		if(!breach.isPresent())
			throw new BreachNotFoundException("No breach request found");
		return null;
	}

}
