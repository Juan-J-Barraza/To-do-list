package com.java.todolist.utils.validators;

import com.java.todolist.dtos.tasks.TaskCreatedDto;
import com.java.todolist.dtos.tasks.TaskUpdatedDto;
import com.java.todolist.enums.TaskStatus;
import com.java.todolist.utils.exeptions.BusinessException;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TaskValidator {
    private TaskStatus status;
    private final int MIN_CHARACTERS = 5;

    public void validateCreateTask(TaskCreatedDto taskDto) throws BusinessException {
        if (Objects.isNull(taskDto)) {
            throw new BusinessException("Task data can not be null");
        }
        if (StringUtils.isBlank(taskDto.getTitle())) {
            throw new BusinessException("Title can not be empty");
        }
        if (StringUtils.isNotBlank(taskDto.getDescription())) {
            if (taskDto.getDescription().length() < this.MIN_CHARACTERS) {
                throw new BusinessException("Description must have at least 5 characters");
            }
        }
    }


    public void validateUpdateTask(TaskUpdatedDto taskDto) throws BusinessException {
        if (Objects.isNull(taskDto)) {
            throw new BusinessException("Task data can not be null");
        }
        if (StringUtils.isBlank(taskDto.getTitle())) {
            throw new BusinessException("Title can not be empty");
        }
        if (StringUtils.isNotBlank(taskDto.getDescription())) {
            if (taskDto.getDescription().length() < this.MIN_CHARACTERS) {
                throw new BusinessException("Description must have at least 5 characters");
            }
        }
        if (Objects.isNull(taskDto.getStatus())) {
            throw new BusinessException("Status can not be null");
        }
    }

}
