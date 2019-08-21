/**
 * 
 */
package com.hcl.breach.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Gurpreet Singh
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ValidateBreachRequestDto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer breachId;
	private String status;
	
}
