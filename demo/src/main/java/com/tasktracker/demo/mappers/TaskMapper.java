package com.tasktracker.demo.mappers;

import com.tasktracker.demo.model.Task;
import com.tasktracker.demo.model.dto.TaskDto;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
