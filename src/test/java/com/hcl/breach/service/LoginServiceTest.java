package com.hcl.breach.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.breach.dto.UserLoginRequestDto;
import com.hcl.breach.entity.Login;
import com.hcl.breach.repository.UserRepository;
@RunWith(MockitoJUnitRunner.class)
/**
 this class is for testing controller class methods
  **/

public class LoginServiceTest {
	
	private static Logger logger = LoggerFactory.getLogger(LoginServiceTest.class);
@Mock UserRepository userRepository;
@InjectMocks LoginServiceImpl loginServiceImpl;

public Login getLogin() {
	Login login = new Login();
	login.setLoginId(1);
	login.setRoleId(2);
	login.setUserName("hackathon");
	login.setPassword("password");
	return login;	
}
public UserLoginRequestDto getUserLoginRequestDto() {
	UserLoginRequestDto UserLoginRequestDto = new UserLoginRequestDto();
	UserLoginRequestDto.setUserName("venkat");
	UserLoginRequestDto.setPassword("password");
	return UserLoginRequestDto;
}
@Test
public void loginTest() {
	logger.info("inside loginTest method ");
	Login login = getLogin();
	UserLoginRequestDto userLoginRequestDto = getUserLoginRequestDto();
	Mockito.when(userRepository.findByUserNameAndPassword(userLoginRequestDto.getUserName(),userLoginRequestDto.getPassword())).thenReturn(Optional.of(login));
	assertEquals("login successfull", loginServiceImpl.loginUser(userLoginRequestDto).getMessage());
}
}
