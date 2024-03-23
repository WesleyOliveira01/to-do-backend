package com.example.crudSpring.Entities.Task;

import com.example.crudSpring.Enums.TaskEnum;

public record CreateNewTask(String title, TaskEnum status) {
    
}
