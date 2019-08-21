/**
 * 
 */
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

import com.hcl.breach.dto.BreachListResponseDto;
import com.hcl.breach.service.BreachRequestServiceImpl;

/**
 * @author Gurpreet Singh
 * This class is use to get the breach requests list by roleId
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class BreachRequestController {
	public static final Logger LOGGER = LoggerFactory.getLogger(BreachRequestController.class);
	
	@Autowired
	BreachRequestServiceImpl breachRequestServiceImpl;
	
	@GetMapping("/getAllBreaches/{roleId}")
	public ResponseEntity<List<BreachListResponseDto>> getAllBreaches(@PathVariable Integer roleId)
	{
		LOGGER.info("in get all breaches by role id method");
				List<BreachListResponseDto> response = breachRequestServiceImpl.getAllBreaches(roleId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}
