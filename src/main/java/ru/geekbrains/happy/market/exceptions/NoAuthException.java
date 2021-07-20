package ru.geekbrains.happy.market.exceptions;

public class NoAuthException extends RuntimeException {
    public NoAuthException(String message) {
        super(message);
    }
}
