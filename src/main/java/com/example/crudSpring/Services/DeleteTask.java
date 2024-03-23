package com.example.crudSpring.Services;

import com.example.crudSpring.Entities.Task.Task;
import com.example.crudSpring.Respositories.TaskRespositories;

public class DeleteTask {
    public static void Delete(String id,TaskRespositories repository) {
        if (id == null) {
            return ;
        }
        var taskFind = repository.findById(id);
        if (taskFind.isEmpty()) {
            return;
        }
        Task task = taskFind.get();
        repository.delete(task);
    }
}
