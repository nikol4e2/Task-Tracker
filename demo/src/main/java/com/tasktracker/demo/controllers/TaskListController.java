package com.tasktracker.demo.controllers;


import com.tasktracker.demo.mappers.TaskListMapper;
import com.tasktracker.demo.model.TaskList;
import com.tasktracker.demo.model.dto.TaskListDto;
import com.tasktracker.demo.repositories.TaskListRepository;
import com.tasktracker.demo.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> listTaksList() {
        return taskListService.listTaksList().stream().map(taskListMapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdTaskList=taskListService.createTaksList(
                taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(createdTaskList);
    }
}
