package com.hcl.breach.service;

import java.util.List;

import com.hcl.breach.dto.BusinessAreaDto;
import com.hcl.breach.dto.FranchiseResponseDto;

public interface FranchiseService {

	List<FranchiseResponseDto> getAllFranchise();

	List<BusinessAreaDto> getAllBusinessAreas(Integer franchiseId);

}
