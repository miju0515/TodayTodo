package com.example.todaytodo.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@RequiredArgsConstructor
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="task")
    private String task;

    @Column(name="preference_point")
    private int preferencePoint;

    @Column(name="importance_point")
    private int importancePoint;

    @Column(name="done")
    private boolean done;

    @Column(name="date")
    private LocalDate date;

    @Column(name ="isWeeklybox")
    private boolean isWeeklybox;

    @Column(name="weeklyId")
    public long weeklyId;


    @Builder
    public Task(String task, int preferencePoint, int importancePoint, LocalDate date, boolean isWeeklybox, long weeklyId){
        this.task = task;
        this.preferencePoint = preferencePoint;
        this.importancePoint = importancePoint;
        this.date=date;
        this.isWeeklybox=isWeeklybox;
        this.weeklyId=weeklyId;
        this.done=false;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
