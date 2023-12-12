package com.example.todaytodo.Entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="SiteUser")
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userno")
    private long userno;

    @Column(unique = true)
    private String userName;

    private String password;

    @Column(unique = true)
    private String nickname;

    @Builder
    public SiteUser(String userName, String password, String nickname){
        this.userName = userName;
        this.password = password;
        this.nickname = nickname;
    }

    public SiteUser() {

    }
}

