package com.example.taskmanager.Interfaces;

import com.example.taskmanager.Enums.StatusEnum;

public interface ITask {
    void changeStatus(StatusEnum status);
    StatusEnum getStatus();
}
