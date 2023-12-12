package com.example.todaytodo.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {
    @GetMapping("/")
    public String statistics(){
        return "statistics";
    }
}
