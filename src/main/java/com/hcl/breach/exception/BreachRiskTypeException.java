package com.hcl.breach.exception;

import java.io.Serializable;

public class BreachRiskTypeException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "No BreachIncidents Found for this type: ";
	public BreachRiskTypeException(String role) {
		super(MESSAGE +role);
		
	}

}
