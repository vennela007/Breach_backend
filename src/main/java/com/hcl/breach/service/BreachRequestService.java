/**
 * 
 */
package com.hcl.breach.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.breach.dto.BreachListResponseDto;

/**
 * @author user1
 *
 */
@Service
public interface BreachRequestService {
	
	public List<BreachListResponseDto> getAllBreaches(Integer roleId);

}
