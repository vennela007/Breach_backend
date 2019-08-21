package com.hcl.breach.exception;

import java.io.Serializable;

public class FranchiseException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "No Franchise Found ";
	public FranchiseException() {
		super(MESSAGE);
		
	}
	
}
