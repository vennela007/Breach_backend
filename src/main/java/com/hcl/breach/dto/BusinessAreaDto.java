package com.hcl.breach.dto;

import java.io.Serializable;

import com.hcl.breach.entity.Franchise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class BusinessAreaDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long areaId;
	private String areaName;
	private Franchise franchise;
}
