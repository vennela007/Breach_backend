/**
 * 
 */
package com.hcl.breach.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.dto.BreachListResponseDto;
import com.hcl.breach.entity.Breach;
import com.hcl.breach.repository.BreachRepository;

/**
 * @author Gurpreet Singh
 *
 */
@Service
public class BreachRequestServiceImpl implements BreachRequestService {
	public static final Logger LOGGER = LoggerFactory.getLogger(BreachRequestServiceImpl.class);

	@Autowired
	BreachRepository breachRepository;
	/**
	 * This method is use to provide list of all breaches by role Id
	 * @param Integer roleId is the input parameter
	 * @return responseList it will return the list of breaches which contains
	 * breachId, franchise, businessArea, businessCategory, description, status, 
	 * riskType, creationDate
	 * 
	 */
	@Override
	public List<BreachListResponseDto> getAllBreaches(Integer roleId) {
		LOGGER.info("in get all breaches by roleId");
		List<BreachListResponseDto> responseList = new ArrayList<>();
		List<Breach> breach = breachRepository.findByRoleId(roleId);
		breach.stream().forEach(b->{
			BreachListResponseDto breachListResponseDto = new BreachListResponseDto();
			BeanUtils.copyProperties(b, breachListResponseDto);
			responseList.add(breachListResponseDto);
		});
		
		return responseList;
	}

}
