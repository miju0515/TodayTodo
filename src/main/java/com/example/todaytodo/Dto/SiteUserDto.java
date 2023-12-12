package com.example.todaytodo.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SiteUserDto {
    @NotEmpty
    String userName;
    @NotEmpty
    String password;
    @NotEmpty
    String nickname;
}
