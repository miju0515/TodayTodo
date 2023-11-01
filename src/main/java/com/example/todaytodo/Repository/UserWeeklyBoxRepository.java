package com.example.todaytodo.Repository;

import com.example.todaytodo.Entity.UserWeeklyBox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserWeeklyBoxRepository extends JpaRepository<UserWeeklyBox,Long> {
    List<UserWeeklyBox> findAllByUserId(long userno);

    List<UserWeeklyBox> findAllByUserIdAndUsed(Long userno,boolean used);
}
