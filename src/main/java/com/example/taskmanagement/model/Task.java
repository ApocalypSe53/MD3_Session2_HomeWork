package com.example.taskmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Task {
    private Integer id;
    private String title;
    private String description;
    private String priority;
    private Integer assignedTo;
}
