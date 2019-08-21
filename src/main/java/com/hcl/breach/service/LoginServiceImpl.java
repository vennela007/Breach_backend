package com.hcl.breach.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hcl.breach.dto.UserLoginRequestDto;
import com.hcl.breach.dto.UserLoginResponseDto;
/**
 * This api is intended to login the the Uesr
 */
@Service
public class LoginServiceImpl implements LoginService{

	private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Override
	public UserLoginResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) {
     logger.info("inside the login method..");
		
		return null;
	}

}
