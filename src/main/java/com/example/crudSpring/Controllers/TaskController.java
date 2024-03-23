package com.example.crudSpring.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.crudSpring.Entities.Task.CreateNewTask;
import com.example.crudSpring.Entities.Task.Task;
import com.example.crudSpring.Respositories.TaskRespositories;
import com.example.crudSpring.Services.CreateTask;
import com.example.crudSpring.Services.DeleteTask;
import com.example.crudSpring.Services.FindTaskById;
import com.example.crudSpring.Services.GetAllTasks;
import com.example.crudSpring.Services.UpdateTask;


@RestController
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private TaskRespositories repository;

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        var tasks = GetAllTasks.GetTasks(repository);
        if (tasks == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        var task = FindTaskById.Find(id, repository);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody CreateNewTask req) {
        System.out.println(req);
        var task = CreateTask.mapToTask(req);
        repository.save(task);
        if (task == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(task);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody CreateNewTask req) {
        var task = UpdateTask.Update(id, req.status(), repository);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable String id) {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }
        DeleteTask.Delete(id, repository);
        return ResponseEntity.ok().build();
    }
}
