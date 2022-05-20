package com.bespoke.drinking.exception;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Integer id) {
		super("User with this id does not exist! - " + id);
	}
}
