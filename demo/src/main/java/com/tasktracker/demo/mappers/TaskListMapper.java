package com.tasktracker.demo.mappers;

import com.tasktracker.demo.model.TaskList;
import com.tasktracker.demo.model.dto.TaskListDto;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
