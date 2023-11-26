package com.example.taskmanager;

import lombok.Data;
import lombok.Getter;

@Getter
public abstract class Task implements ITask {
    private Integer id;
    private String description;
    private StatusEnum status;

    public Task(Integer id, String description, StatusEnum status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    @Override
    public void changeStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public StatusEnum getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
