package org.example.exeption;

public class BilletIndisponibleException extends RuntimeException {
    public BilletIndisponibleException(String message) {
        super(message);
    }
}
