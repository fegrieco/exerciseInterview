package com.lastminute.exercise.exception;

public class CalcualteTaxException extends RuntimeException {

    private String message;

    public CalcualteTaxException (String message){
        super(message);
        this.message= message;
    }

    public CalcualteTaxException(String message,Throwable throwable){
        super(message,throwable);
        this.message=message;
    }
}
