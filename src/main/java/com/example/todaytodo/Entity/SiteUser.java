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
    private String id;

    private String password;

    @Column(unique = true)
    private String nickname;

    @Builder
    public SiteUser(String id, String password, String nickname){
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }
}

