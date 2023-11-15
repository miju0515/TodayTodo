package com.example.todaytodo.Controller;

import com.example.todaytodo.Dto.TaskDto;
import com.example.todaytodo.Entity.Task;
import com.example.todaytodo.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/new")
    public String createForm(){
        return "Task/mainPage";
    }

    @PostMapping("/add")
    public String addTask(TaskDto taskDto){
        taskService.addTask(taskDto);
        return "redirect:/task/group";
    }

    @GetMapping("/group")
    public String groupPage(Model model){
        List<Task> taskList = taskService.findAllTask();
        model.addAttribute("tasks",taskList);
        return "Task/mainPage";
    }

    @GetMapping("/delete")
    public String deleteTask(long id){
        taskService.deleteTask(id);
        return "redirect:/task/group";
    }

    @GetMapping("/postpone")
    public String postponeTask(long id){
        taskService.postponeTask(id);
        return "redirect:/task/group";
    }

    @GetMapping("/done")
    public String doneTask(long id){
        taskService.doneTask(id);
        return "redirect:/task/group";
    }
}
