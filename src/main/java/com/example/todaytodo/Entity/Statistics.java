package com.example.todaytodo.Entity;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="Statistics")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float monthly;
    private long postpone;

    private long userno;

    @Builder
    public Statistics(long userno){
        this.monthly=0;
        this.postpone=0;
        this.userno=userno;
    }
}
