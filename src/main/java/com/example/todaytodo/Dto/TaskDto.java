package com.example.todaytodo.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private String task;
    private int preference_point;
    private int importance_point;
}
