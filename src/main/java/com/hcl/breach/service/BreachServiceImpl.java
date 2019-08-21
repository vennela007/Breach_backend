package com.hcl.breach.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.dto.BreachRequestDto;
import com.hcl.breach.dto.BreachResponseDto;
import com.hcl.breach.dto.BusinessCategoryResponseDto;
import com.hcl.breach.entity.Breach;
import com.hcl.breach.entity.BusinessCategory;
import com.hcl.breach.entity.RiskProfile;
import com.hcl.breach.entity.RiskType;
import com.hcl.breach.repository.BreachRepository;
import com.hcl.breach.repository.BusinessCategoryRepository;
import com.hcl.breach.repository.RiskProfileRepository;

/**
 * 
 * @author HAriPriya G
 *
 */
@Service
public class BreachServiceImpl implements BreachService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BreachServiceImpl.class);
	@Autowired BusinessCategoryRepository businessCategoryRepository;
	@Autowired
	BreachRepository breachRepository;

	@Autowired
	RiskProfileRepository riskProfileRepository;
	
	/**
	 * 
	 * This method is intended to create the breach
	 * @param BreachRequestDto is the input request which 
	 * includes franchise, businessArea, businessCategory, description, id
	 * @return it returns  BreachResponseDto object with message and login id 
	 */

	@Override
	public BreachResponseDto createBreach(BreachRequestDto breachRequestDto) {
		LOGGER.info("Creating breach service impl");
		Breach breach = new Breach();
		breach.setBusinessArea(breachRequestDto.getBusinessArea());
		breach.setBusinessCategory(breachRequestDto.getBusinessCategory());
		breach.setDescription(breachRequestDto.getDescription());
		breach.setFranchise(breachRequestDto.getFranchise());
		breach.setStatus("P");
		breach.setRoleId(breachRequestDto.getId());

		Optional<RiskProfile> riskProfile = riskProfileRepository.findByFranchiseAndBusinessAreaAndBreachCategory(
				breach.getFranchise(), breach.getBusinessArea(), breach.getBusinessCategory());
		if (!riskProfile.isPresent())
			breach.setRiskType(RiskType.L.toString());
		else
			breach.setRiskType(riskProfile.get().getRisk());

		breachRepository.save(breach);
		

		return new BreachResponseDto("Breach created successfully", breachRequestDto.getId());

	}
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