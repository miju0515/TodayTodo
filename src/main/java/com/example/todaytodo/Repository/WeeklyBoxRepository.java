package com.example.todaytodo.Repository;


import com.example.todaytodo.Entity.WeeklyBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklyBoxRepository extends JpaRepository {
    WeeklyBox findByUserId(long userno);
}
