package com.example.todaytodo.Service;

import com.example.todaytodo.Entity.SiteUser;
import com.example.todaytodo.Entity.Task;
import com.example.todaytodo.Entity.UserWeeklyBox;
import com.example.todaytodo.Entity.WeeklyBox;
import com.example.todaytodo.Repository.JpaTaskRepository;
import com.example.todaytodo.Repository.WeeklyBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeeklyBoxService {
    private final WeeklyBoxRepository weeklyBoxRepository;
    private final JpaTaskRepository jpaTaskRepository;

    public void addUserWeeklyBox(SiteUser user,String task){
        WeeklyBox weeklyBox = weeklyBoxRepository.findByUserId(user.getUserno());

        UserWeeklyBox userWeeklyBox = UserWeeklyBox.builder()
                .userId(user.getUserno())
                .weeklyBoxId(weeklyBox.getId())
                .task(task)
                .build();

        weeklyBoxRepository.save(userWeeklyBox);

    }

    public void addWeeklyBoxtoTask(Long id){
        Optional<UserWeeklyBox> thistask = weeklyBoxRepository.findById(id);
        UserWeeklyBox userWeeklyBox = thistask.get();

        LocalDate now = LocalDate.now();

        Task task = Task.builder()
                .task(userWeeklyBox.getTask())
                .importance_point(0)
                .preference_point(3)
                .date(now)
                .build();
        jpaTaskRepository.save(task);

        userWeeklyBox.setUsed(false);
        weeklyBoxRepository.save(userWeeklyBox);
    }


}
