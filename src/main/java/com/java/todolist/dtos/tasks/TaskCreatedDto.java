package com.java.todolist.dtos.tasks;

import com.java.todolist.enums.TaskStatus;

import java.time.LocalDate;

public class TaskCreatedDto {
    private String title;
    private String description;
    private LocalDate creationDate;

    public TaskCreatedDto () {}

    public TaskCreatedDto (String title, String description, LocalDate creationDate) {
        this.title = title;
        this.description = description;

        this.creationDate = creationDate;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}