package com.example.todaytodo.Controller;

import com.example.todaytodo.Service.WeeklyBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weeklybox")
public class WeeklyBoxController {
    private final WeeklyBoxService weeklyBoxService;
}
