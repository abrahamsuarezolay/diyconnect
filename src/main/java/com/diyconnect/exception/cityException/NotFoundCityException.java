package com.diyconnect.exception.cityException;

public class NotFoundCityException extends CityException {
    public NotFoundCityException() {
        super("City not found");
    }
}
