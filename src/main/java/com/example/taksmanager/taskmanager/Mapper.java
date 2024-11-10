package com.example.taksmanager.taskmanager;

import com.example.taksmanager.taskmanager.dto.TaskDto;
import com.example.taksmanager.taskmanager.model.Task;

public class Mapper {
    public  static TaskDto toTaskDto(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskDto.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatut(task.getStatut());
        taskDto.setDuration(task.getDuration());
        taskDto.setPeriode(task.getPeriode());
        taskDto.setStartdate(task.getStartdate());

        return taskDto;
    }

    public  static Task toTask(TaskDto taskdto){
        Task task = new Task();
        task.setId(taskdto.getId());
        task.setTitle(taskdto.getTitle());
        task.setDescription(taskdto.getDescription());
        task.setStatut(taskdto.getStatut());
        task.setDuration(taskdto.getDuration());
        task.setPeriode(taskdto.getPeriode());
        task.setStartdate(taskdto.getStartdate());
        return task;
    }
}
