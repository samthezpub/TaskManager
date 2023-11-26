package com.example.taskmanager.Models;

import com.example.taskmanager.Enums.StatusEnum;
import com.example.taskmanager.Exceptions.NotFoundException;
import com.example.taskmanager.Interfaces.ITaskManager;
import com.example.taskmanager.Models.Task;
import com.example.taskmanager.Models.TaskList;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TaskManager implements ITaskManager {

    private List<TaskList> taskLists = new ArrayList<>();

    private TaskList findTaskList(TaskList taskList) throws NotFoundException {
        TaskList foundedTaskList = taskLists.stream()
                .filter((tl) -> tl.getTitle().equals(taskList.getTitle()))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(
                        String.format("TaskList с именем %s не найден", taskList.getTitle())
                ));
        return foundedTaskList;
    }
    public void addTaskList(TaskList taskList) {
        taskLists.add(taskList);
    }
    @Override
    public void addTask(TaskList taskList, Task task) {
        try {
            findTaskList(taskList).addTask(task);
        } catch (NotFoundException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void changeStatus(TaskList taskList, Task task, StatusEnum statusEnum){
        try {
            findTaskList(taskList).changeStatus(task, statusEnum);
        } catch (NotFoundException e) {
            log.error(e.getMessage());
        }

    }

    @Override
    public void deleteTask(TaskList taskList, Task task) {
        try {
            findTaskList(taskList).deleteTask(task);
        } catch (NotFoundException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public List<Task> getFilteredTasksByStatus(TaskList taskList, StatusEnum status) {
        try {
            return findTaskList(taskList).getFilteredTasksByStatus(status);
        } catch (NotFoundException e) {
            log.error(e.getMessage());
        }
        return new ArrayList<Task>(0);
    }


}
