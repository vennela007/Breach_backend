package com.hcl.breach.service;

import org.springframework.stereotype.Service;

import com.hcl.breach.dto.UserLoginRequestDto;
import com.hcl.breach.dto.UserLoginResponseDto;

@Service
public interface LoginService {

	public UserLoginResponseDto loginUser(UserLoginRequestDto userLoginRequestDto);
}
