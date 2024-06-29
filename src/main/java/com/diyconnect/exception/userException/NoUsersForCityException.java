package com.diyconnect.exception.userException;

public class NoUsersForCityException extends UserException{

    public NoUsersForCityException() {
        super("There is no users for that city");
    }
}
