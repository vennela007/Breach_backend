package com.hcl.breach.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.breach.dto.UserLoginRequestDto;
import com.hcl.breach.dto.UserLoginResponseDto;
import com.hcl.breach.entity.Login;
import com.hcl.breach.exception.UserNotFoundException;
import com.hcl.breach.repository.UserRepository;
/**
 * This api is intended to login the the Uesr
 */
@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired UserRepository userRepository;

	private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Override
	public UserLoginResponseDto loginUser(UserLoginRequestDto userLoginRequestDto) {
		logger.info("inside the login method..");
	Optional<Login> login = userRepository.findByUserNameAndPassword(userLoginRequestDto.getUserName()
			, userLoginRequestDto.getPassword());
	if(!login.isPresent())
		throw new UserNotFoundException("User not found");
	else
		return new UserLoginResponseDto("login successfull", login.get().getRoleId());
	}
}
