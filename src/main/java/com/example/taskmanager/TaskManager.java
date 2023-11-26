package com.example.taskmanager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void changeStatus(TaskList taskList, Task task, StatusEnum statusEnum){
        try {
            findTaskList(taskList).changeStatus(task, statusEnum);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void deleteTask(TaskList taskList, Task task) {
        try {
            findTaskList(taskList).deleteTask(task);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Task> getFilteredTasksByStatus(TaskList taskList, StatusEnum status) {
        try {
            return findTaskList(taskList).getFilteredTasksByStatus(status);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<Task>(0);
    }


}
