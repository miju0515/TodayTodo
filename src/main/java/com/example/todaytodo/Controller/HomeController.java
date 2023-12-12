package com.example.todaytodo.Controller;

import com.example.todaytodo.Dto.LoginDto;
import com.example.todaytodo.Dto.SiteUserDto;
import com.example.todaytodo.Service.SiteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final SiteUserService siteUserService;

    @GetMapping("/")
    public String home(){
        siteUserService.add();
        return "home";
    }


    @GetMapping("/signup")
    public String signup(){
        return "User/UserJoin";
    }

    @GetMapping("/login")
    public String login(){
        return "User/UserLogin";
    }

    @PostMapping("/user/login")
    public String doLogin(LoginDto loginDto){
        siteUserService.loadUserByUsername(loginDto.getUserName());
        return "redirect:/task/group";
    }

    @PostMapping("/join")
    public String signup(SiteUserDto siteUserDto){
        siteUserService.create(siteUserDto);
        System.out.println("join!");
        return "redirect:/";
    }

    @GetMapping("/user/logout")
    public String logout(){
        return "home";
    }

}
