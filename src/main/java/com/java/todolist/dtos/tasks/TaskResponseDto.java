package com.java.todolist.dtos.tasks;

import com.java.todolist.enums.TaskStatus;

import java.time.LocalDate;

public class TaskResponseDto {
    private Long idTask;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate createdDate;


    public TaskResponseDto() {}

    public TaskResponseDto(Long idTask, String title, String description, TaskStatus status, LocalDate createdDate) {
        this.idTask = idTask;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdDate = createdDate;
    }


    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
