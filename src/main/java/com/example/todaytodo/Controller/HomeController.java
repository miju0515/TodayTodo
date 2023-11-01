package com.example.todaytodo.Controller;

import com.example.todaytodo.Service.SiteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final SiteUserService siteUserService;

    @GetMapping("/")
    public String home(){
        siteUserService.add();
        return "home";
    }
}
