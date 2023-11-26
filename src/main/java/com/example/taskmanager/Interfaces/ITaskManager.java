package com.example.taskmanager.Interfaces;

import com.example.taskmanager.Models.Task;
import com.example.taskmanager.Models.TaskList;
import com.example.taskmanager.Exceptions.NotFoundException;
import com.example.taskmanager.Enums.StatusEnum;

import java.util.List;

public interface ITaskManager {
    void addTaskList(TaskList taskList);
    void addTask(TaskList taskList, Task task) throws NotFoundException;

    void changeStatus(TaskList taskList, Task task, StatusEnum statusEnum) throws NotFoundException;

    void deleteTask(TaskList taskList, Task task);

    List<Task> getFilteredTasksByStatus(TaskList taskList, StatusEnum status);
}
