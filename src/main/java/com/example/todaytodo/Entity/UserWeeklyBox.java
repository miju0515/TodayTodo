package com.example.todaytodo.Entity;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name="userWeeklyBox")
public class UserWeeklyBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long weeklyBoxId;

    private String task;



    private boolean used = true;
    public void setUsed(boolean used) {
        this.used = used;
    }

    @Builder
    public UserWeeklyBox(Long userId, Long weeklyBoxId,String task){
        this.userId = userId;
        this.weeklyBoxId = weeklyBoxId;
        this.task = task;
    }
}
