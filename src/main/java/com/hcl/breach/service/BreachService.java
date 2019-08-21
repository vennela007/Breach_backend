package com.hcl.breach.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.hcl.breach.dto.BusinessCategoryResponseDto;
import com.hcl.breach.dto.BreachRequestDto;
import com.hcl.breach.dto.BreachResponseDto;
@Service
public interface BreachService {
	
	BreachResponseDto createBreach(BreachRequestDto breachRequestDto);

	public List<BusinessCategoryResponseDto> getAllCategories();

}
