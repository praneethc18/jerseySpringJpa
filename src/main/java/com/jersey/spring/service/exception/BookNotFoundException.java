package com.jersey.spring.service.exception;


public class BookNotFoundException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String s) {
		super(s);
	}
}
