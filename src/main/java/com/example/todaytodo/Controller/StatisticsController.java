package com.example.todaytodo.Controller;


import com.example.todaytodo.Service.SiteUserService;
import com.example.todaytodo.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/statistics")
public class StatisticsController {
    private final TaskService taskService;
    private final SiteUserService siteUserService;

    String name;
    Long userno;

    @GetMapping("/")
    public String statistics(Principal principal){
        name = principal.getName();
        userno = siteUserService.findId(name);
        return "statistics";
    }

    @PostMapping("/")
    public String viewStatistics(Model model){
        long totalAchievement = taskService.totalAchievement(userno);
        long postpone = taskService.countPostpone(userno);
        model.addAttribute("total",totalAchievement);
        model.addAttribute("postpone",postpone);
        return "redirect:/statistics";
    }
}
