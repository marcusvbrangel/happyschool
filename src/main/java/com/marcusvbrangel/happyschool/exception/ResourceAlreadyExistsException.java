package com.marcusvbrangel.happyschool.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }

    public ResourceAlreadyExistsException() {
        this("The resource already exists");
    }

}