package ru.mts.mtsjavacourse.exceptions;

public class WrongAgeException extends NumberFormatException {
    public WrongAgeException(String message) {
        super(message);
    }
}