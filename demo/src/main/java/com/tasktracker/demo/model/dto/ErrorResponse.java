package com.tasktracker.demo.model.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
