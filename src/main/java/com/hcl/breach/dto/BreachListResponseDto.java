/**
 * 
 */
package com.hcl.breach.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author user1
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BreachListResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer breachId;
	private String franchise;
	private String businessArea;
	private String businessCategory;
	private String description;
	private String status;
	private String riskType;
	@CreationTimestamp
	private LocalDate creationDate;
}
