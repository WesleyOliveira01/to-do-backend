package com.example.crudSpring.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crudSpring.Entities.Task.Task;

public interface TaskRespositories extends JpaRepository<Task, String> {}
