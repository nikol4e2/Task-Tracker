package com.tasktracker.demo.mappers.impl;

import com.tasktracker.demo.mappers.TaskMapper;
import com.tasktracker.demo.model.Task;
import com.tasktracker.demo.model.dto.TaskDto;
import org.springframework.stereotype.Component;


@Component
public class TaskMapperImpl implements TaskMapper {


    @Override
    public Task fromDto(TaskDto taskDto) {
        return new Task(taskDto.id(), taskDto.title(), taskDto.description(),taskDto.dueDate(),taskDto.status(),taskDto.priority(),null,null,null);
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
        );
    }
}
