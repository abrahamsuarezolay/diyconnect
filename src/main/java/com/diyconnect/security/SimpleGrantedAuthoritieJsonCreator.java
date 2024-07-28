package com.diyconnect.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGrantedAuthoritieJsonCreator {


    @JsonCreator
    public SimpleGrantedAuthoritieJsonCreator(@JsonProperty("authority") String role){

    }
}
