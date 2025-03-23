package com.tasktracker.demo.model.dto;

import com.tasktracker.demo.model.enums.TaskPriority;
import com.tasktracker.demo.model.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
