package com.musinsa.assignment.urlshortener.exception;

public class NotValidException extends IllegalArgumentException{
    public NotValidException(String message){
        super(message);
    }
}
