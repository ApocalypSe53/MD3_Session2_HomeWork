package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();

    public TaskRepository() {
        tasks.add(new Task(1, "Task 1", "Description 1", "high", 1));
        tasks.add(new Task(2, "Task 2", "Description 2", "medium", 2));
        tasks.add(new Task(3, "Task 3", "Description 3", "low", 3));
        tasks.add(new Task(4, "Task 4", "Description 4", "high", 1));
        tasks.add(new Task(5, "Task 5", "Description 5", "medium", 2));
        tasks.add(new Task(6, "Task 6", "Description 6", "low", 3));
        tasks.add(new Task(7, "Task 7", "Description 7", "high", 1));
        tasks.add(new Task(8, "Task 8", "Description 8", "medium", 2));
        tasks.add(new Task(9, "Task 9", "Description 9", "low", 3));
        tasks.add(new Task(10, "Task 10", "Description 10", "high", 2));
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task save(Task task) {
        int nextId = tasks.stream()
                .mapToInt(Task::getId)
                .max()
                .orElse(0) + 1;
        task.setId(nextId);
        tasks.add(task);
        return task;
    }
}
