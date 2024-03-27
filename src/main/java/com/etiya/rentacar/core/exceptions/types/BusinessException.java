package com.etiya.rentacar.core.exceptions.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);//Çalışma zamanında hata verir.
    }
}
