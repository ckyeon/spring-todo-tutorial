package com.sequence.todo.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    USER_NOT_FOUND("User Not Found"),
    TODO_NOT_FOUND("Todo Not Found"),
    DUPLICATE_EMAIL("Duplicate Email");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
