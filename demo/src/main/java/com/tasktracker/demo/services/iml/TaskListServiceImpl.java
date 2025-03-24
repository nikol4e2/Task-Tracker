package com.tasktracker.demo.services.iml;

import com.tasktracker.demo.model.TaskList;
import com.tasktracker.demo.repositories.TaskListRepository;
import com.tasktracker.demo.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

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
}
