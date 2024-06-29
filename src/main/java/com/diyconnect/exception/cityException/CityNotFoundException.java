package com.diyconnect.exception.cityException;

public class CityNotFoundException extends CityException {
    public CityNotFoundException() {
        super("City not found");
    }
}
