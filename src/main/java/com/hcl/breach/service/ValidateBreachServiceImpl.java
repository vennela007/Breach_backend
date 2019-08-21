/**
 * 
 */
package com.hcl.breach.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.dto.ValidateBreachRequestDto;
import com.hcl.breach.dto.ValidateBreachResponseDto;
import com.hcl.breach.entity.Breach;
import com.hcl.breach.exception.BreachNotFoundException;
import com.hcl.breach.repository.BreachRepository;

/**
 * @author Gurpeet Singh
 * This class is used to close/reject/reopen the breach requests.
 *
 */
@Service
public class ValidateBreachServiceImpl implements ValidateBreachService{
	public static final Logger LOGGER = LoggerFactory.getLogger(ValidateBreachServiceImpl.class);
	
	@Autowired
	BreachRepository breachRepository;

	/**
	 * This method is use to accept/reject/reopen the breach
	 * @param ValidateBreachRequestDto is the input request which includes 
	 * breachId and status
	 * @return ValidateBreachResponseDto is the output response which gives the 
	 * message with status code 200
	 * @exception BreachNotFoundException if no breach request found in the database 
	 */
	@Override
	public ValidateBreachResponseDto validateBreach(ValidateBreachRequestDto validateBreachRequestDto) {
		LOGGER.info("in validate breach method");
		String status = null;
		Optional<Breach> breach = breachRepository.findById(validateBreachRequestDto.getBreachId());
		
		if(!breach.isPresent())
			throw new BreachNotFoundException("No breach request found");
		if(!breach.get().getBreachId().equals(validateBreachRequestDto.getBreachId()))
			throw new BreachNotFoundException("No breach request found");
		
		breach.get().setStatus(validateBreachRequestDto.getStatus());
		breachRepository.save(breach.get());
		
		if(validateBreachRequestDto.getStatus().equalsIgnoreCase("C"))
			status = "The breach is closed";
		if(validateBreachRequestDto.getStatus().equalsIgnoreCase("P"))
			status = "The breach is reopened";
		if(validateBreachRequestDto.getStatus().equalsIgnoreCase("R"))
			status = "The breach is rejected";
		return new ValidateBreachResponseDto(status);
	}

}
