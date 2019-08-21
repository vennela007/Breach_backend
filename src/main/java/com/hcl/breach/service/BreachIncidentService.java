package com.hcl.breach.service;

import java.util.List;

import com.hcl.breach.dto.BreachIncidentResponseDto;

public interface BreachIncidentService {

	List<BreachIncidentResponseDto> getAllBreachIncidents(String role);

}
