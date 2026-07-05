package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(
            @RequestParam(required = false) String search) {

        List<Task> allTasks = taskService.findAllTasks();

        if (search == null || search.trim().isEmpty()) {
            return ResponseEntity.ok(allTasks);
        }

        List<Task> filteredTasks = allTasks.stream()
                .filter(task -> task.getTitle().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(filteredTasks);
    }
}