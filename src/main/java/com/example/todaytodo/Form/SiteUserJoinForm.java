package com.example.todaytodo.Form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SiteUserJoinForm {
    @NotEmpty(message="아이디는 필수항목입니다")
    private String id;

    @NotEmpty(message="비밀번호는 필수항목입니다")
    private String password;

    @NotEmpty(message="닉네임은 필수항목입니다")
    private String nickname;
}
