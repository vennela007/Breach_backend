package com.hcl.breach.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.dto.BusinessCategoryResponseDto;
import com.hcl.breach.entity.BusinessCategory;
import com.hcl.breach.repository.BusinessCategoryRepository;
@Service
public class BreachServiceImpl implements BreachService{

	@Autowired BusinessCategoryRepository businessCategoryRepository;
	@Override
	public List<BusinessCategoryResponseDto> getAllCategories() {
		
		List<BusinessCategoryResponseDto> responseList = new ArrayList<>();
		List<BusinessCategory> categoryList = businessCategoryRepository.findAll();
		
		categoryList.stream().forEach(c ->{
			BusinessCategoryResponseDto response = new BusinessCategoryResponseDto();
			BeanUtils.copyProperties(c,response);
			responseList.add(response);
		});
		return responseList;
		
	}

}
