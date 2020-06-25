package com.nagarro.micro.aggregator.exception;

public class UserNotFoundException extends RuntimeException{
	
	private long id;
	private String message;

	public UserNotFoundException(Long id, String message) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.message=message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5388564855919643478L;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
