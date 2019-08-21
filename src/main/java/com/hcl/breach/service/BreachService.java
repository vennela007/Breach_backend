package com.hcl.breach.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.breach.dto.BusinessCategoryResponseDto;
@Service
public interface BreachService {

	public List<BusinessCategoryResponseDto> getAllCategories();

}
