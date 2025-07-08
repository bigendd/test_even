package org.example.classes;

public class BilletIndisponibleException extends RuntimeException {
    public BilletIndisponibleException(String message) {
        super(message);
    }
}
