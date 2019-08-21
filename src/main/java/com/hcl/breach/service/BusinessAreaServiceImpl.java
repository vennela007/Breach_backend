package com.hcl.breach.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.dto.BusinessAreaDto;
import com.hcl.breach.entity.BusinessArea;
import com.hcl.breach.exception.BusinessAreaException;
import com.hcl.breach.repository.BusinessAreaRepository;

/**
 * 
 * @author DeepikaSivarajan
 *
 */
@Service
public class BusinessAreaServiceImpl implements BusinessAreaService {
	@Autowired
	BusinessAreaRepository businessAreaRepository;
	
	/**
	 * 
	 * This method is intended to list of businessAreas
	 * @param franchiseId is the input request
	 * @return it returns BusinessAreaDto list  
	 */

	@Override
	public List<BusinessAreaDto> getAllBusinessAreas(Integer franchiseId) {
		List<BusinessAreaDto> responseList = new ArrayList<>();
		List<BusinessArea> areaList = businessAreaRepository.findByFranchiseFranchiseId(franchiseId);
		if (areaList.isEmpty()) {
			throw new BusinessAreaException();
		} else {
			areaList.stream().forEach(a -> {
				BusinessAreaDto businessAreaDto = new BusinessAreaDto();
				BeanUtils.copyProperties(a, businessAreaDto);
				responseList.add(businessAreaDto);
			});
		}
		return responseList;
	}

}
