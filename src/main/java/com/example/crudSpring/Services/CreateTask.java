package com.example.crudSpring.Services;

import com.example.crudSpring.Entities.Task.CreateNewTask;
import com.example.crudSpring.Entities.Task.Task;

public class CreateTask {

    public static Task mapToTask(CreateNewTask req) {
        var task = new Task(req.title(), req.status());
        return task;
    }
}
