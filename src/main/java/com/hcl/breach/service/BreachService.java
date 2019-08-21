package com.hcl.breach.service;

import com.hcl.breach.dto.BreachRequestDto;
import com.hcl.breach.dto.BreachResponseDto;

public interface BreachService {
	
	BreachResponseDto createBreach(BreachRequestDto breachRequestDto);

}
