package com.example.todaytodo.Dto;

import lombok.Getter;

@Getter
public class TaskDto {

    private String task;
    private int preference_point;
    private int importance_point;
}
