package com.hcl.breach.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breach.dto.BusinessAreaDto;
import com.hcl.breach.dto.FranchiseResponseDto;
import com.hcl.breach.service.BusinessAreaService;
import com.hcl.breach.service.FranchiseService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
public class FranchiseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FranchiseController.class);

	@Autowired
	FranchiseService franchiseService;
	@Autowired
	BusinessAreaService businessAreaService;
	
	@GetMapping("/franchises")
	public ResponseEntity<List<FranchiseResponseDto>> getAllFranchise() {
		LOGGER.info("inside franchise");
		List<FranchiseResponseDto> response = franchiseService.getAllFranchise();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/businessAreas/{franchiseId}")
	public ResponseEntity<List<BusinessAreaDto>> getAllBusinessAreas(@PathVariable Integer franchiseId) {
		LOGGER.info("inside business Area");
		List<BusinessAreaDto> response = businessAreaService.getAllBusinessAreas(franchiseId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
