package com.test.supermarket;

public class InvalidProductException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidProductException(String id) {
		super("Invalid Product ID : " + id);
	}
}
