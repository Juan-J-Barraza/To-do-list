package com.java.todolist.repositories;

import com.java.todolist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ITaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.id = :id")
    Optional<Task> findTaskById(Long id);

    boolean existsByTitle(String title);

}
