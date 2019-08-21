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
 * @author user1
 *
 */
@Service
public class BreachRequestServiceImpl implements BreachRequestService {
	public static final Logger LOGGER = LoggerFactory.getLogger(BreachRequestServiceImpl.class);

	@Autowired
	BreachRepository breachRepository;
	/**
	 * This method is use to provide
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
