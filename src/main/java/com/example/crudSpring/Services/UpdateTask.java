package com.example.crudSpring.Services;

import com.example.crudSpring.Entities.Task.Task;
import com.example.crudSpring.Enums.TaskEnum;
import com.example.crudSpring.Respositories.TaskRespositories;

public class UpdateTask {
    public static Task Update(String id, TaskEnum status, TaskRespositories repository) {
        if (id == null || status == null) {
            return null;
        }
        var taskFind = repository.findById(id);
        if (taskFind.isEmpty()) {
            return null;
        }
        Task task = taskFind.get();
        task.setStatus(status);
        repository.save(task);
        return task;
    }
}
