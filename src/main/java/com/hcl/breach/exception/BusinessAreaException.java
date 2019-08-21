package com.hcl.breach.exception;

import java.io.Serializable;

public class BusinessAreaException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "No BusinessAreas Found";

	public BusinessAreaException() {
		super(MESSAGE);

	}

}
