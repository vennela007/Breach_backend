package com.hcl.breach.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.breach.dto.BusinessAreaDto;
import com.hcl.breach.entity.BusinessArea;
import com.hcl.breach.repository.BusinessAreaRepository;

@RunWith(MockitoJUnitRunner.class)
public class BusinessAreaServiceImplTest {

	@Mock
	BusinessAreaRepository businessAreaRepository;
	@InjectMocks
	BusinessAreaServiceImpl businessAreaServiceImpl;

	List<BusinessAreaDto> responseList;
	BusinessAreaDto businessAreaDto;
	List<BusinessArea> businessAreaList;
	BusinessArea businessArea;

	@Before
	public void setUp() {
		responseList = new ArrayList<>();
		businessAreaDto = new BusinessAreaDto();
		businessAreaList = new ArrayList<>();
		businessArea = new BusinessArea();
		businessArea.setAreaId(1);
		businessArea.setAreaName("Business Banking");
		businessAreaList.add(businessArea);
		businessAreaDto.setAreaId(1);
		businessAreaDto.setAreaName("Business Banking");
		responseList.add(businessAreaDto);

	}

	@Test
	public void testGetAllBusinessAreas() {
		Mockito.when(businessAreaRepository.findByFranchiseFranchiseId(Mockito.anyInt())).thenReturn(businessAreaList);
		List<BusinessAreaDto> areaDetails = businessAreaServiceImpl.getAllBusinessAreas(1);
		Assert.assertEquals(responseList.get(0).getAreaName(), areaDetails.get(0).getAreaName());

	}

}
