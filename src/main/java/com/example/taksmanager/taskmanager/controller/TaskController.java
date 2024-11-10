package com.example.taksmanager.taskmanager.controller;  

import com.example.taksmanager.taskmanager.dto.TaskDto;
import com.example.taksmanager.taskmanager.model.Task;
import com.example.taksmanager.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.*;  

import java.util.List;  

@RestController  
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {  

    private final TaskService taskService;  



    @PostMapping  
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto createdTask = taskService.createTask(taskDto);
        return ResponseEntity.ok(createdTask);
    }  

    @GetMapping("/{id}")  
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }  

    @GetMapping  
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<TaskDto> taskDtos = taskService.getAllTasks();
        return ResponseEntity.ok(taskDtos);
    }  

    @PutMapping("/{id}")  
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        TaskDto updatedTask = taskService.updateTask(id, taskDto);
        return ResponseEntity.ok(updatedTask);
    }  

    @DeleteMapping("/{id}")  
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {  
        taskService.deleteTask(id);  
        return ResponseEntity.noContent().build(); // Retourne un 204 No Content  
    }  
}