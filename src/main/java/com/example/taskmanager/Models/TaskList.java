package com.example.taskmanager.Models;

import com.example.taskmanager.Interfaces.ITaskList;
import com.example.taskmanager.Exceptions.NotFoundException;
import com.example.taskmanager.Enums.StatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TaskList implements ITaskList {

    private String title;
    private List<Task> tasks = new ArrayList<>();

    public TaskList(String title) {
        this.title = title;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void changeStatus(Task task, StatusEnum statusEnum) throws NotFoundException {
        Task task1 = tasks.stream()
                .filter((t) -> t.hashCode() == task.hashCode())
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Искомая таска не найдена!"));

        task1.changeStatus(statusEnum);
    }

    public void deleteTask(Task task){
        tasks.remove(task);
    }

    public List<Task> getFilteredTasksByStatus(StatusEnum status){
        List<Task> filteredTasks = tasks.stream()
                .filter((t) -> t.getStatus() == status)
                .collect(Collectors.toList());
        return filteredTasks;
    }

    public String getTitle() {
        return title;
    }
}
