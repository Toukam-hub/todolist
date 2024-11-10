package com.example.taksmanager.taskmanager.service.imp;

import com.example.taksmanager.taskmanager.Mapper;
import com.example.taksmanager.taskmanager.dto.TaskDto;
import com.example.taksmanager.taskmanager.exception.ResourceAlresdyExistException;
import com.example.taksmanager.taskmanager.exception.ResourceNotFounfException;
import com.example.taksmanager.taskmanager.model.Task;
import com.example.taksmanager.taskmanager.repository.TaskRepository;
import com.example.taksmanager.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private  final TaskRepository taskRepository;
    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = Mapper.toTask(taskDto);
        if (taskRepository.existsByDescription(task.getDescription())){
            throw  new ResourceAlresdyExistException("This task already exist");
        }
        if (task.getPeriode() != null) {
            task.setTime(task.getPeriode().toString());
        } else if (task.getDuration() != null) {
            task.setTime(task.getDuration().toString());
        }

        return Mapper.toTaskDto(taskRepository.save(task));
    }

    @Override
    public TaskDto getTaskById(Long id) {
        return Mapper.toTaskDto( taskRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFounfException("This tash doesn't exist in data base")
        ));

    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream().map(Mapper::toTaskDto).toList();
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskUpdate) {

        Task taskInDataBase = taskRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFounfException("This tash doesn't exist in data base")
        );

        taskInDataBase.setId(taskUpdate.getId());
        taskInDataBase.setTitle(taskUpdate.getTitle());
        taskInDataBase.setDescription(taskUpdate.getDescription());
        taskInDataBase.setStatut(taskUpdate.getStatut());
        taskInDataBase.setStartdate(taskUpdate.getStartdate());
        taskInDataBase.setPeriode(taskUpdate.getPeriode());
        taskInDataBase.setDuration(taskUpdate.getDuration());

        if (taskInDataBase.getPeriode() != null) {
            taskInDataBase.setTime(taskInDataBase.getPeriode().toString());
        } else if (taskInDataBase.getDuration() != null) {
            taskInDataBase.setTime(taskInDataBase.getDuration().toString());
        }

        return Mapper.toTaskDto(taskRepository.save(taskInDataBase));
    }

    @Override
    public String deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFounfException("This tash doesn't exist in data base");
        }
        taskRepository.deleteById(id);
        return "task delet successfuly !";
    }
}
