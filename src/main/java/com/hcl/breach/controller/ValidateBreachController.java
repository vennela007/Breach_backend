/**
 * 
 */
package com.hcl.breach.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breach.dto.ValidateBreachRequestDto;
import com.hcl.breach.dto.ValidateBreachResponseDto;
import com.hcl.breach.service.ValidateBreachService;
import com.hcl.fundtransfer.dto.ConfirmOtpRequestDto;
import com.hcl.fundtransfer.dto.ConfirmOtpResponseDto;


/**
 * @author Gurpreet Singh
 * This class is used to validate breach like closed/reject/pending
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ValidateBreachController {
	public static final Logger LOGGER = LoggerFactory.getLogger(ValidateBreachController.class);
	
	@Autowired
	ValidateBreachService validateBreachService;
	
	@PutMapping("/validatebreach")
	public ResponseEntity<ValidateBreachResponseDto> vaildateBreach(@RequestBody ValidateBreachRequestDto validateBreachRequestDto) {
		LOGGER.info(" credit Otp  controller");
		ValidateBreachResponseDto response = validateBreachService.validateBreach(validateBreachRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
