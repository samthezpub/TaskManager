package com.example.taskmanager.Models;

import com.example.taskmanager.Enums.StatusEnum;

public class DefaultTask extends Task {

    public DefaultTask(Integer id, String description, StatusEnum status) {
        super(id, description, status);
    }
}
