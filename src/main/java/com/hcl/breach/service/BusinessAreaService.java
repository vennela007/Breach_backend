package com.hcl.breach.service;

import java.util.List;

import com.hcl.breach.dto.BusinessAreaDto;

public interface BusinessAreaService {

	List<BusinessAreaDto> getAllBusinessAreas(Integer franchiseId);

	

}
