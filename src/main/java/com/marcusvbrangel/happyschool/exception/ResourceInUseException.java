package com.marcusvbrangel.happyschool.exception;

public class ResourceInUseException extends RuntimeException {

    public ResourceInUseException(String message) {
        super(message);
    }

    public ResourceInUseException() {
        this("The resource already in use");
    }
}