package ru.geekbrains.happy.market.homework.exceptions;

public class NoAuthException extends RuntimeException {
    public NoAuthException(String message) {
        super(message);
    }
}
