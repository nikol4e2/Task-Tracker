package com.tasktracker.demo.services.iml;

import com.tasktracker.demo.model.TaskList;
import com.tasktracker.demo.repositories.TaskListRepository;
import com.tasktracker.demo.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaksList() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaksList(TaskList taskList) {
        if(taskList.getId() != null)
        {
            throw new IllegalArgumentException("Task list already has an ID!");
        }
        if(taskList.getTasks() == null || taskList.getTitle().isBlank())
        {
            throw new IllegalArgumentException("Task list title must be present!");
        }
        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new TaskList(null,taskList.getTitle(),taskList.getDescription(),null,now,now));
    }

    @Override
    public Optional<TaskList> getTaskList(UUID id) {
        return taskListRepository.findById(id);
    }

    @Override
    public TaskList updateTaksList(UUID id, TaskList taskList) {
        if(taskList.getId() == null)
        {
            throw new IllegalArgumentException("Task list does not have an ID!");
        }

        if(!Objects.equals(taskList.getId(), id))
        {
            throw new IllegalArgumentException("Attempting to change the ID, this is not permitted!");
        }

        TaskList existingTaskList = taskListRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Task list does not exist!"));

        existingTaskList.setTitle(taskList.getTitle());
        existingTaskList.setDescription(taskList.getDescription());
        existingTaskList.setUpdated(LocalDateTime.now());
        return taskListRepository.save(existingTaskList);
    }

    @Override
    public void deleteTaksList(UUID id) {
        taskListRepository.deleteById(id);
    }
}
