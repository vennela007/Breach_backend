package com.hcl.breach.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breach.dto.BusinessCategoryResponseDto;
import com.hcl.breach.service.BreachService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class BreachController {
	private static  Logger logger= LoggerFactory.getLogger("BreachController.class");
	
	@Autowired BreachService breachService;
	@GetMapping("/getAllCategories")
	public ResponseEntity<List<BusinessCategoryResponseDto>> getBreachCategories() {
		
		logger.info("inside the getBusinessCategories method");
		
		List<BusinessCategoryResponseDto> response = breachService.getAllCategories();
		
		return  new ResponseEntity<>(response , HttpStatus.OK);
	} 
	
}
