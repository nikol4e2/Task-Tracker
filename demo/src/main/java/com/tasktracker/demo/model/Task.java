package com.tasktracker.demo.model;

import com.tasktracker.demo.model.enums.TaskPriority;
import com.tasktracker.demo.model.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id",updatable = false, nullable = false)
    private UUID id;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "status",nullable = false)
    private TaskStatus status;

    @Column(name = "priority",nullable = false)
    private TaskPriority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="task_list_id")
    private TaskList taskList;


    @Column(name="created",nullable = false)
    private LocalDateTime created;

    @Column(name = "updated",nullable = false)
    private LocalDateTime updated;


    public Task() {
    }

    public Task(UUID id, String title, String description, LocalDateTime dueDate, TaskStatus status, TaskPriority priority, TaskList taskList, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.taskList = taskList;
        this.created = created;
        this.updated = updated;
    }
}
