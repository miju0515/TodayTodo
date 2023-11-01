package com.example.todaytodo.Repository;


import com.example.todaytodo.Entity.UserWeeklyBox;
import com.example.todaytodo.Entity.WeeklyBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeeklyBoxRepository extends JpaRepository<WeeklyBox,Long>{


    WeeklyBox findByUserId(long userno);
}
