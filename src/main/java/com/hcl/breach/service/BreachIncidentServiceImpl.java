package com.hcl.breach.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.dto.BreachIncidentResponseDto;
import com.hcl.breach.entity.Breach;
import com.hcl.breach.exception.BreachRiskTypeException;
import com.hcl.breach.repository.BreachRepository;

/**
 * 
 * @author DeepikaSivarajan
 *
 */
@Service
public class BreachIncidentServiceImpl implements BreachIncidentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BreachIncidentServiceImpl.class);

	@Autowired
	BreachRepository breachRepository;

	/**
	 * 
	 * This method is intended to list breaches based on role
	 * 
	 * @param role is the input request
	 * @return it returns BreachIncidentResponseDto list with roleId
	 * 
	 */

	@Override
	public List<BreachIncidentResponseDto> getAllBreachIncidents(String role) {
		LOGGER.info("breach incident service");
		List<BreachIncidentResponseDto> breachList = new ArrayList<>();

		if (role.equals("A")) {
			List<Breach> closedBreaches = breachRepository.findByRoleIdAndStatus(2, "C");
			closedBreaches.stream().forEach(p -> {
				BreachIncidentResponseDto response = new BreachIncidentResponseDto();
				BeanUtils.copyProperties(p, response);
				breachList.add(response);
			});

		} else {
			List<Breach> allBreaches = breachRepository.findByStatus("P");
			allBreaches.stream().forEach(b -> {
				String riskType = b.getRiskType();

				if (role.equalsIgnoreCase(riskType)) {
					BreachIncidentResponseDto response = new BreachIncidentResponseDto();
					BeanUtils.copyProperties(b, response);
					breachList.add(response);
				}

				else {
					throw new BreachRiskTypeException(role);
				}
			});
		}

		return breachList;
	}

}
