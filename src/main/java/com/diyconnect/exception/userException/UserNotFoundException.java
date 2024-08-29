package com.diyconnect.exception.userException;

public class UserNotFoundException extends UserException {
    public UserNotFoundException() { super("The request user does not exist in the system."); }
}
