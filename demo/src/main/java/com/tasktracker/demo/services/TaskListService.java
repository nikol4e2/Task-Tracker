package com.tasktracker.demo.services;

import com.tasktracker.demo.model.TaskList;
import com.tasktracker.demo.model.dto.TaskListDto;

import java.util.List;

public interface TaskListService {

    List<TaskList> listTaksList();
    TaskList createTaksList(TaskList taskList);
}
