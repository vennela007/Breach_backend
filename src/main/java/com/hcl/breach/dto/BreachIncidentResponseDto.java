package com.hcl.breach.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BreachIncidentResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String franchise;
	private String businessArea;
	private String businessCategory;
	private String description;
	private String status;
	private String riskType;
	private Integer roleId;
}
