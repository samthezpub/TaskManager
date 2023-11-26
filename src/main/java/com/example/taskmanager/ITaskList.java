package com.example.taskmanager;

import java.util.List;
import java.util.stream.Collectors;

public interface ITaskList {
    public void addTask(Task task);

    public void changeStatus(Task task, StatusEnum statusEnum) throws NotFoundException;

    public void deleteTask(Task task);

    public List<Task> getFilteredTasksByStatus(StatusEnum status);
}
