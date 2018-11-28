package com.lastminute.exercise.exception;

public class InvalidProductExecption extends RuntimeException {

    private String message;

    public InvalidProductExecption (String message){
        super(message);
        this.message= message;
    }

    public InvalidProductExecption(String message,Throwable throwable){
        super(message,throwable);
        this.message=message;
    }
}
