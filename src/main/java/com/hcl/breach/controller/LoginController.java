package com.hcl.breach.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.breach.dto.UserLoginRequestDto;
import com.hcl.breach.dto.UserLoginResponseDto;
import com.hcl.breach.service.LoginService;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"} , origins = {"*","/"})
@RequestMapping("/api")
public class LoginController {

	private static  Logger logger= LoggerFactory.getLogger("LoginController.class"); 
	@Autowired LoginService loginService;
	
	public ResponseEntity<UserLoginResponseDto> userLogin(@RequestBody UserLoginRequestDto userLoginRequestDto ){
		logger.info("in login customer method");
	UserLoginResponseDto response = loginService.loginUser(userLoginRequestDto);
		return new ResponseEntity<>( response, HttpStatus.OK);
	}
}
