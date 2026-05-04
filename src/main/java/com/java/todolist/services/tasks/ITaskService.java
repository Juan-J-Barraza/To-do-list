package com.java.todolist.services.tasks;

import com.java.todolist.dtos.tasks.TaskCreatedDto;
import com.java.todolist.dtos.tasks.TaskResponseDto;
import com.java.todolist.dtos.tasks.TaskUpdatedDto;

import java.util.List;

public interface ITaskService {
    public TaskResponseDto createTask(TaskCreatedDto task);
    public TaskResponseDto getTaskById(Long id);
    public List<TaskResponseDto> getAllTask();
    public TaskResponseDto updateTask(TaskUpdatedDto task, Long id);
    public void deleteTask(Long id);
}
