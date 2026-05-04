package com.java.todolist.utils;

import com.java.todolist.dtos.tasks.TaskCreatedDto;
import com.java.todolist.dtos.tasks.TaskResponseDto;
import com.java.todolist.dtos.tasks.TaskUpdatedDto;
import com.java.todolist.models.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class Mapper {

    public TaskResponseDto mapperTaskEntityToTaskResponse(Task task) {
        return new TaskResponseDto(task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreationDate());
    }

    public Task mapperTaskCreateToTask(TaskCreatedDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCreationDate(LocalDate.now());
        return task;
    }

}
