package com.diyconnect.exception.bandException;

public class NoBandForCityException extends BandException {
    public NoBandForCityException() {
        super("There are no bands for that city");
    }
}
