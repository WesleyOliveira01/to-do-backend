package com.example.crudSpring.Services;

import java.util.List;

import com.example.crudSpring.Entities.Task.Task;
import com.example.crudSpring.Respositories.TaskRespositories;

public class GetAllTasks {

    public static List<Task> GetTasks(TaskRespositories repository) {
        List<Task> tasks = repository.findAll();
        if (tasks.size() == 0) {
            return null;
        }
        return tasks;
    }
}
