package com.reservationapp.exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String s) {
        super(s);
    }
}
