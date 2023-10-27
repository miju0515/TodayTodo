package com.example.todaytodo.Controller;


import com.example.todaytodo.Form.SiteUserJoinForm;
import com.example.todaytodo.Service.SiteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class SiteUserController {
    private final SiteUserService siteUserService;

    @GetMapping("/signup")
    public String signup(SiteUserJoinForm siteUserJoinForm){
        return "User/UserJoin";
    }

    @PostMapping("/signup")
    public String signup(@Valid SiteUserJoinForm siteUserJoinForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "User/UserJoin";
        }
        siteUserService.join(siteUserJoinForm.getId(),siteUserJoinForm.getPassword(),siteUserJoinForm.getNickname());
        return "redirect:/";
    }

}
