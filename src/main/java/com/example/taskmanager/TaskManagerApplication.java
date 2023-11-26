package com.example.taskmanager;

import com.example.taskmanager.Enums.StatusEnum;
import com.example.taskmanager.Models.DefaultTask;
import com.example.taskmanager.Models.DefaultTaskList;
import com.example.taskmanager.Models.Task;
import com.example.taskmanager.Models.TaskManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);

        TaskManager taskManager = new TaskManager();

        DefaultTaskList defaultTaskList = new DefaultTaskList("Обычный список");
        DefaultTask defaultTask = new DefaultTask(1, "Обычная таска", StatusEnum.TODO);
        DefaultTask secondDefaultTask = new DefaultTask(2, "Вторая Обычная таска", StatusEnum.TODO);
        DefaultTask inProgressDefaultTask = new DefaultTask(3, "Таска в процессе", StatusEnum.INPROGRESS);

        taskManager.addTaskList(defaultTaskList);
        taskManager.addTask(defaultTaskList, defaultTask);
        taskManager.addTask(defaultTaskList,secondDefaultTask);
        taskManager.addTask(defaultTaskList,inProgressDefaultTask);

        // Для вызова исключения
        taskManager.addTask(new DefaultTaskList("Ошибочный"), secondDefaultTask);

        for (Task task: taskManager.getFilteredTasksByStatus(defaultTaskList, StatusEnum.INPROGRESS)) {
            System.out.println(task.toString());
        }

        taskManager.changeStatus(defaultTaskList, inProgressDefaultTask, StatusEnum.TODO);
        for (Task task: taskManager.getFilteredTasksByStatus(defaultTaskList, StatusEnum.INPROGRESS)) {
            System.out.println(task.toString());
        }

        System.out.println();
        for (Task task: taskManager.getFilteredTasksByStatus(defaultTaskList, StatusEnum.TODO)) {
            System.out.println(task.toString());
        }

        System.out.println();
        taskManager.deleteTask(defaultTaskList, secondDefaultTask);
        for (Task task: taskManager.getFilteredTasksByStatus(defaultTaskList, StatusEnum.TODO)) {
            System.out.println(task.toString());
        }
    }

}
