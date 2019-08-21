package com.hcl.breach.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.dto.BreachIncidentResponseDto;
import com.hcl.breach.entity.Breach;
import com.hcl.breach.entity.Login;
import com.hcl.breach.repository.BreachRepository;
import com.hcl.breach.repository.UserRepository;

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
	
	@Autowired
	UserRepository userRepository;

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
			List<Breach> closedBreaches = breachRepository.findByStatus("C");
			closedBreaches.stream().forEach(p -> {
				Optional<Login> login=userRepository.findById(p.getRoleId());
				
				BreachIncidentResponseDto response = new BreachIncidentResponseDto();
				response.setRoleName(login.get().getUserName());
				BeanUtils.copyProperties(p, response);
				breachList.add(response);
			});

		} else {
			List<Breach> allBreaches = breachRepository.findByStatus("P");
			allBreaches.stream().forEach(b -> {
				Optional<Login> login=userRepository.findById(b.getRoleId());
				String riskType = b.getRiskType();

				if (role.equalsIgnoreCase(riskType)) {
					BreachIncidentResponseDto response = new BreachIncidentResponseDto();
					response.setRoleName(login.get().getUserName());
					BeanUtils.copyProperties(b, response);
					breachList.add(response);
				}

			});
		}

		return breachList;
	}

}
