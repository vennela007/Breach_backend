package com.hcl.breach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breach.dto.BreachRequestDto;
import com.hcl.breach.dto.BreachResponseDto;
import com.hcl.breach.service.BreachService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class BreachController {

	@Autowired
	BreachService breachService;

	@PostMapping("/createBreach")
	public ResponseEntity<BreachResponseDto> createBreach(@RequestBody BreachRequestDto breachRequestDto) {
		return new ResponseEntity<>(breachService.createBreach(breachRequestDto), HttpStatus.CREATED);
	}

}
