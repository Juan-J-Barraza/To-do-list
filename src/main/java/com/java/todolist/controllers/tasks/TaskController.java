package com.java.todolist.controllers.tasks;

import com.java.todolist.dtos.tasks.TaskCreatedDto;
import com.java.todolist.dtos.tasks.TaskResponseDto;
import com.java.todolist.dtos.tasks.TaskUpdatedDto;
import com.java.todolist.services.tasks.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskCreatedDto taskDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(taskDto));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTask() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long id, @RequestBody TaskUpdatedDto taskDto) {
        return ResponseEntity.ok(taskService.updateTask(taskDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

}
