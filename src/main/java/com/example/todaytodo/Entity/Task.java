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
    private int preference_point;

    @Column(name="importance_point")
    private int importance_point;

    @Column(name="done")
    private boolean done;

    @Column(name="date")
    private LocalDate date;

    @Builder
    public Task(String task, int preference_point, int importance_point, LocalDate date){
        this.task = task;
        this.preference_point=preference_point;
        this.importance_point=importance_point;
        this.date=date;
    }
}
