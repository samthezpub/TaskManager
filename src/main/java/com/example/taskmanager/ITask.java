package com.example.taskmanager;

public interface ITask {
    void changeStatus(StatusEnum status);
    StatusEnum getStatus();
}
