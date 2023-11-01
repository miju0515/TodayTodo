package com.example.todaytodo.Controller;

import com.example.todaytodo.Dto.UserWeeklyBoxDto;
import com.example.todaytodo.Entity.SiteUser;
import com.example.todaytodo.Entity.UserWeeklyBox;
import com.example.todaytodo.Entity.WeeklyBox;
import com.example.todaytodo.Service.WeeklyBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/weeklybox")
public class WeeklyBoxController {
    private final WeeklyBoxService weeklyBoxService;

    @GetMapping("")
    public String Weeklyhome(){
        return "WeeklyBox";
    }

    @GetMapping("/view")
    public String viewWeeklyBox(Model model){
        List<UserWeeklyBox> weeklyBoxes = weeklyBoxService.findAllWeeklyBox(1L);
        model.addAttribute("weeklyboxs",weeklyBoxes);
        return "WeeklyBox";
    }

    @PostMapping("/add")
    public String addWeeklyBox(UserWeeklyBoxDto userWeeklyBoxDto){
        weeklyBoxService.addUserWeeklyBox(1L,userWeeklyBoxDto);
        return "redirect:/weeklybox/view";
    }

    @GetMapping("/move")
    public String moveWeeklyBox(Long id){
        weeklyBoxService.addWeeklyBoxtoTask(id);
        return "redirect:/task/group";
    }

    @GetMapping("/delete")
    public String deleteWeeklyBox(Long id){
        weeklyBoxService.deleteUserWeeklyBox(id);
        return "redirect:/weeklybox/view";
    }


}
