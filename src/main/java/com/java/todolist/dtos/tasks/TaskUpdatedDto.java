package com.java.todolist.dtos.tasks;

import com.java.todolist.enums.TaskStatus;

public class TaskUpdatedDto {
    private String title;
    private String description;
    private TaskStatus status;


    public TaskUpdatedDto() {}

    public TaskUpdatedDto(String title, String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this. status = status;
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
}
