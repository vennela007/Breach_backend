package com.hcl.breach.controller;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.hcl.breach.service.BreachServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class BreachControllerTest {
	@Mock
	BreachServiceImpl breachServiceImpl;
	@InjectMocks BreachController breachController;
	
}
