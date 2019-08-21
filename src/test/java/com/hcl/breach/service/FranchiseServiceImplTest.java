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

import com.hcl.breach.dto.FranchiseResponseDto;
import com.hcl.breach.entity.Franchise;
import com.hcl.breach.repository.FranchiseRepository;

@RunWith(MockitoJUnitRunner.class)
public class FranchiseServiceImplTest {

	@Mock
	FranchiseRepository franchiseRepository;
	@InjectMocks
	FranchiseServiceImpl franchiseServiceImpl;

	List<Franchise> franchiseList;
	Franchise franchise;

	@Before
	public void setUp() {
		franchiseList = new ArrayList<>();
		franchise = new Franchise();
		franchise.setFranchiseId(1);
		franchise.setFranchiseName("RBSI");
		franchiseList.add(franchise);
	}

	@Test
	public void testGetAllFranchise() {
		Mockito.when(franchiseRepository.findAll()).thenReturn(franchiseList);
		List<FranchiseResponseDto> response = franchiseServiceImpl.getAllFranchise();
		Assert.assertEquals("RBSI", response.get(0).getFranchiseName());
	}
}
