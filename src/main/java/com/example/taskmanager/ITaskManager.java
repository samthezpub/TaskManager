package com.example.taskmanager;

import java.util.List;

public interface ITaskManager {
    void addTaskList(TaskList taskList);
    void addTask(TaskList taskList, Task task) throws NotFoundException;

    void changeStatus(TaskList taskList, Task task, StatusEnum statusEnum) throws NotFoundException;

    void deleteTask(TaskList taskList, Task task);

    List<Task> getFilteredTasksByStatus(TaskList taskList, StatusEnum status);
}
