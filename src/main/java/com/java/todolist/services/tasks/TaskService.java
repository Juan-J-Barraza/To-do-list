package com.java.todolist.services.tasks;

import com.java.todolist.dtos.tasks.TaskCreatedDto;
import com.java.todolist.dtos.tasks.TaskResponseDto;
import com.java.todolist.dtos.tasks.TaskUpdatedDto;
import com.java.todolist.enums.TaskStatus;
import com.java.todolist.models.Task;
import com.java.todolist.repositories.ITaskRepository;
import com.java.todolist.utils.Mapper;
import com.java.todolist.utils.exeptions.BusinessException;
import com.java.todolist.utils.exeptions.ResourceNotFoundException;
import com.java.todolist.utils.validators.TaskValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {
    private final ITaskRepository taskRepo;
    private final Mapper mapper;
    private final TaskValidator validator;


    public TaskService(ITaskRepository taskRepo, Mapper mapper, TaskValidator validator) {
        this.taskRepo = taskRepo;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public TaskResponseDto createTask(TaskCreatedDto task) {
        validator.validateCreateTask(task);
        if (taskRepo.existsByTitle(task.getTitle())) {
            throw new BusinessException("Task already exist with this title");
        }
        Task taskEntity = mapper.mapperTaskCreateToTask(task);
        taskRepo.save(taskEntity);

        return mapper.mapperTaskEntityToTaskResponse(taskEntity);
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        Task taskEntity = taskRepo.findTaskById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        return mapper.mapperTaskEntityToTaskResponse(taskEntity);
    }

    @Override
    public List<TaskResponseDto> getAllTask() {
        return taskRepo.findAll()
                .stream()
                .map(mapper::mapperTaskEntityToTaskResponse)
                .toList();
    }

    @Override
    public TaskResponseDto updateTask(TaskUpdatedDto task, Long id) {
        validator.validateUpdateTask(task);

        Task taskEntity = taskRepo.findTaskById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        if (task.getStatus() == TaskStatus.COMPLETED
                && taskEntity.getStatus() == TaskStatus.PENDING) {
            throw new BusinessException("Task must be IN PROGRESS before COMPLETED");
        }
        if (task.getStatus() == TaskStatus.PENDING
                && taskEntity.getStatus() != TaskStatus.PENDING) {
            throw new BusinessException("Task cannot go back to PENDING");
        }

        taskEntity.setTitle(task.getTitle());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setStatus(task.getStatus());
        return mapper.mapperTaskEntityToTaskResponse(taskRepo.save(taskEntity));
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepo.existsById(id)) {
            throw new ResourceNotFoundException("Task not found");
        }
        taskRepo.deleteById(id);
    }
}
