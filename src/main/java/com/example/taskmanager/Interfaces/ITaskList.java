package com.example.taskmanager.Interfaces;

import com.example.taskmanager.Models.Task;
import com.example.taskmanager.Exceptions.NotFoundException;
import com.example.taskmanager.Enums.StatusEnum;

import java.util.List;

public interface ITaskList {
    public void addTask(Task task);

    public void changeStatus(Task task, StatusEnum statusEnum) throws NotFoundException;

    public void deleteTask(Task task);

    public List<Task> getFilteredTasksByStatus(StatusEnum status);
}
