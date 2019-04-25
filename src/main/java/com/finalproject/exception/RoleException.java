package com.finalproject.exception;

public class RoleException extends Exception {

	
	public RoleException(String message)
	{
		super("RoleException-"+message);
	}
	
	public RoleException(String message, Throwable cause)
	{
		super("RoleException-"+message,cause);
	}
}
