package com.etiya.rentacar.core.exceptions.types;

public class InternalServerErrorException extends InternalError {

    public InternalServerErrorException(String message){
        super(message);
    }
}
