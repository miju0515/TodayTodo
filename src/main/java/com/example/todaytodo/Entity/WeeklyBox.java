package com.example.todaytodo.Entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name="weeklyBox")
public class WeeklyBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Date startDate;

    public WeeklyBox(long userno, LocalDate now) {
        this.userId=userno;
        this.startDate= Date.valueOf(now);
    }
}
