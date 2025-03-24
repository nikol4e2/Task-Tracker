package com.tasktracker.demo.repositories;


import com.tasktracker.demo.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskListRepository  extends JpaRepository<TaskList, UUID> {

}
