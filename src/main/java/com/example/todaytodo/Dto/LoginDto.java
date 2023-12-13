package com.example.todaytodo.Dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class LoginDto {
    @NotEmpty
    String username;
    @NotEmpty
    String password;
}
