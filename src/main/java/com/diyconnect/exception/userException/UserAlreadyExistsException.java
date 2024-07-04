package com.diyconnect.exception.userException;

public class UserAlreadyExistsException extends UserException {

    public UserAlreadyExistsException() {
        super("The user you are trying to add already exists");
    }
}
