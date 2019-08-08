package com.websitedockergradle.exceptionhandlers;

public class CustomExceptionHandler extends RuntimeException{
	
	public CustomExceptionHandler(String exception) {
		super(exception);
	}
}
