package com.example.taksmanager.taskmanager.service;  

import com.example.taksmanager.taskmanager.dto.TaskDto;
import com.example.taksmanager.taskmanager.model.Task;

import java.util.List;  
import java.util.Optional;  

public interface TaskService {  
    TaskDto createTask(TaskDto taskDto);
    TaskDto getTaskById(Long id);
    List<TaskDto> getAllTasks();
    TaskDto updateTask(Long id, TaskDto taskDto);
    String deleteTask(Long id);
}