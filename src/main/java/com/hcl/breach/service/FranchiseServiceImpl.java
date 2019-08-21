package com.hcl.breach.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.dto.FranchiseResponseDto;
import com.hcl.breach.entity.Franchise;
import com.hcl.breach.exception.FranchiseException;
import com.hcl.breach.repository.FranchiseRepository;

/**
 * 
 * @author DeepikaSivarajan
 *
 */
@Service
public class FranchiseServiceImpl implements FranchiseService {

	@Autowired
	FranchiseRepository franchiseRepository;
	
	/**
	 * 
	 * This method is intended to list of franchiseDetails
	 * @param no input request
	 * @return it returns FranchiseResponseDto list
	 */
	
	@Override
	public List<FranchiseResponseDto> getAllFranchise() {
		List<FranchiseResponseDto> responseList = new ArrayList<>();
		List<Franchise> franchiseList = franchiseRepository.findAll();
		if(franchiseList.isEmpty()) {
			throw new FranchiseException();
		}
		else {
		franchiseList.stream().forEach(f->{
			FranchiseResponseDto franchiseResponseDto = new FranchiseResponseDto();
			BeanUtils.copyProperties(f, franchiseResponseDto);
			responseList.add(franchiseResponseDto);
		});
		}
		return responseList;
	}

	
	
}
