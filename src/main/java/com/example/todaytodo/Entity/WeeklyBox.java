package com.example.todaytodo.Entity;


import lombok.Getter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Table(name="weeklyBox")
public class WeeklyBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Date startDate;

}
