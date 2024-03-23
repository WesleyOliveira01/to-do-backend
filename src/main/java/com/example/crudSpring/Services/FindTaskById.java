package com.example.crudSpring.Services;

import com.example.crudSpring.Entities.Task.Task;
import com.example.crudSpring.Respositories.TaskRespositories;

public class FindTaskById {

    public static Task Find(String id, TaskRespositories repository) {
        if (id == null) {
            return null;
        }
        var taskFind = repository.findById(id);
        if (taskFind.isEmpty()) {
            return null;
        }
        Task task = taskFind.get();
        return task;
    }
}
