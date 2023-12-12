package com.example.todaytodo.Controller;

import com.example.todaytodo.Dto.TaskDto;
import com.example.todaytodo.Entity.Task;
import com.example.todaytodo.Service.SiteUserService;
import com.example.todaytodo.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final SiteUserService siteUserService;
    LocalDate now = LocalDate.now();
    String name;
    Long userno;

    @GetMapping("/new")
    public String createForm(Principal principal){
        name = principal.getName();
        userno = siteUserService.findId(name);
        return "Task/mainPage";
    }

    @PostMapping("/add")
    public String addTask(TaskDto taskDto){
        taskService.addTask(taskDto,userno);
        return "redirect:/task/group";
    }

    @GetMapping("/group")
    public String groupPage(Model model){
        List<Task> taskList = taskService.findAllTask(now,userno);
        model.addAttribute("tasks",taskList);

        int month = Integer.valueOf(now.format(DateTimeFormatter.ofPattern("MM")));
        model.addAttribute("month",month);
        int date = Integer.valueOf(now.format(DateTimeFormatter.ofPattern("dd")));
        model.addAttribute("date",date);

        long achievement = taskService.todayAchievement();
        model.addAttribute("achievement", achievement);
        return "Task/mainPage";
    }

    @GetMapping("/delete")
    public String deleteTask(long id){
        taskService.deleteTask(id);
        return "redirect:/task/group";
    }

    @GetMapping("/postpone")
    public String postponeTask(long id){
        taskService.postponeTask(id,now);
        return "redirect:/task/group";
    }

    @GetMapping("/done")
    public String doneTask(long id){
        taskService.doneTask(id);
        return "redirect:/task/group";
    }

    @GetMapping("/plusDate")
    public String plusDate(Model model){
        now = now.plusDays(1);
        List<Task> taskList = taskService.findAllTask(now,userno);
        model.addAttribute("tasks",taskList);

        int month = Integer.valueOf(now.format(DateTimeFormatter.ofPattern("MM")));
        model.addAttribute("month",month);
        int date = Integer.valueOf(now.format(DateTimeFormatter.ofPattern("dd")));
        model.addAttribute("date",date);
        return "redirect:/task/group";
    }

    @GetMapping("/minusDate")
    public String minusDate(Model model){
        now = now.minusDays(1);
        List<Task> taskList = taskService.findAllTask(now,userno);
        model.addAttribute("tasks",taskList);

        int month = Integer.valueOf(now.format(DateTimeFormatter.ofPattern("MM")));
        model.addAttribute("month",month);
        int date = Integer.valueOf(now.format(DateTimeFormatter.ofPattern("dd")));
        model.addAttribute("date",date);
        return "redirect:/task/group";
    }
}
