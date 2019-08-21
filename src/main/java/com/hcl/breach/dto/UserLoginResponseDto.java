package com.hcl.breach.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponseDto {

	private String message;
	private Integer roleId;
	
	
}
