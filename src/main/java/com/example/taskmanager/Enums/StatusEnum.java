package com.example.taskmanager.Enums;

import lombok.Getter;

public enum StatusEnum {
    TODO("Нужно сделать"),
    INPROGRESS("В процессе"),
    DONE("Выполнено");

    StatusEnum(String status) {
    }

}
