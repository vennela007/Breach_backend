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

import com.hcl.breach.dto.BreachIncidentResponseDto;
import com.hcl.breach.service.BreachIncidentService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class BreachIncidentController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BreachIncidentController.class);
	
	@Autowired
	BreachIncidentService breachIncidentService;
	
	@GetMapping("/breaches/{role}")
	public ResponseEntity<List<BreachIncidentResponseDto>> getAllBreachIncidents(@PathVariable String role ) {
		LOGGER.info("Breach incidents listed");
		List<BreachIncidentResponseDto> response = breachIncidentService.getAllBreachIncidents(role);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
