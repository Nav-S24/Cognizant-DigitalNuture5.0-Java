package com.cognizant.orm.learn.exception;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException(String countryCode) {
        super("Country not found with code: " + countryCode);
    }
}
