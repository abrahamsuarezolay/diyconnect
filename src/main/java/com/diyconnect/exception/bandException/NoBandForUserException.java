package com.diyconnect.exception.bandException;

public class NoBandForUserException extends BandException{
    public NoBandForUserException() {
        super("There are no bands for that user");
    }
}
