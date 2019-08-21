package com.hcl.breach.exception;

import java.io.Serializable;

public class BreachIncidentException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "No BreachIncidents Found";
	public BreachIncidentException() {
		super(MESSAGE);
		
	}
	
}
