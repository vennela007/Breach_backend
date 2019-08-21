package com.hcl.breach.dto;

import java.io.Serializable;
import java.util.List;

import com.hcl.breach.entity.BusinessArea;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class FranchiseResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer franchiseId;
	private String franchiseName;
	private List<BusinessArea> businessArea;

}
