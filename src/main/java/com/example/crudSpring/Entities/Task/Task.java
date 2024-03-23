package com.example.crudSpring.Entities.Task;



import com.example.crudSpring.Enums.TaskEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    @Enumerated(EnumType.STRING)
    private TaskEnum status;

    public Task() {
    }

    public Task(String title, TaskEnum status) {
        this.title = title;
        this.status = status;
    }

    public String getTilte(){
        return this.title;
    }

    public TaskEnum getStatus(){
        return this.status;
    }

    public void setStatus(TaskEnum status) {
        this.status = status;
    }

}
