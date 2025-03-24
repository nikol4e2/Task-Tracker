package com.tasktracker.demo.services;

import com.tasktracker.demo.model.TaskList;
import com.tasktracker.demo.model.dto.TaskListDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {

    List<TaskList> listTaksList();
    TaskList createTaksList(TaskList taskList);
    Optional<TaskList> getTaskList(UUID id);
    TaskList updateTaksList(UUID id, TaskList taskList);
    void deleteTaksList(UUID id);
}
