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

import com.hcl.breach.dto.BusinessCategoryResponseDto;
import com.hcl.breach.entity.BusinessCategory;
import com.hcl.breach.repository.BusinessCategoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class BreachServiceImplTest {
@Mock BusinessCategoryRepository BusinessRepo;
@InjectMocks BreachServiceImpl breachServiceImpl;
List<BusinessCategory> categoryList;
BusinessCategory businessCategory;
@Before
public void setUp() {
	categoryList = new ArrayList<>();
	businessCategory = new BusinessCategory();
	businessCategory.setCategoryId(1);;
	businessCategory.setCategoryName("pin/card issues");
	categoryList.add(businessCategory);
}
@Test
public void testGetAllCategories() {
	Mockito.when(BusinessRepo.findAll()).thenReturn(categoryList);
	List<BusinessCategoryResponseDto> response = breachServiceImpl.getAllCategories();
	Assert.assertEquals("pin/card issues", response.get(0).getCategoryName());
}
}
