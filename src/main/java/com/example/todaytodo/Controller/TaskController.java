package com.example.todaytodo.Controller;

import com.example.todaytodo.Dto.TaskDto;
import com.example.todaytodo.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/add")
    public void addTask(@Valid TaskDto taskDto){
        taskService.addTask(taskDto);
    }
}
