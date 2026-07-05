package com.example.taskmanagement.service;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.model.User;
import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task newTask) {
        User assignedUser = userService.findUserById(newTask.getAssignedTo());

        if (assignedUser == null) {
            return null;
        }

        return taskRepository.save(newTask);
    }

}
