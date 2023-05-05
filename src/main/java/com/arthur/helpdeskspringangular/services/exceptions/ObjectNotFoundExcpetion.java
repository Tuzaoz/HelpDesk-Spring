package com.arthur.helpdeskspringangular.services.exceptions;

public class ObjectNotFoundExcpetion extends RuntimeException{

    public ObjectNotFoundExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundExcpetion(String message) {
        super(message);
    }
}
