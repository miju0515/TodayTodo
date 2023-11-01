package com.example.todaytodo.Service;

import com.example.todaytodo.Dto.UserWeeklyBoxDto;
import com.example.todaytodo.Entity.SiteUser;
import com.example.todaytodo.Entity.Task;
import com.example.todaytodo.Entity.UserWeeklyBox;
import com.example.todaytodo.Entity.WeeklyBox;
import com.example.todaytodo.Repository.JpaTaskRepository;
import com.example.todaytodo.Repository.UserWeeklyBoxRepository;
import com.example.todaytodo.Repository.WeeklyBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeeklyBoxService {
    private final WeeklyBoxRepository weeklyBoxRepository;
    private final JpaTaskRepository jpaTaskRepository;
    private final UserWeeklyBoxRepository userWeeklyBoxRepository;

    public void addUserWeeklyBox(Long userno, UserWeeklyBoxDto userWeeklyBoxDto){
        WeeklyBox weeklyBox = weeklyBoxRepository.findByUserId(userno);

        UserWeeklyBox userWeeklyBox = UserWeeklyBox.builder()
                .userId(userno)
                .weeklyBoxId(weeklyBox.getId())
                .task(userWeeklyBoxDto.getTask())
                .build();

        userWeeklyBoxRepository.save(userWeeklyBox);

    }

    public void deleteUserWeeklyBox(Long id){
        Optional<UserWeeklyBox> thistask = userWeeklyBoxRepository.findById(id);
        UserWeeklyBox userWeeklyBox = thistask.get();

        userWeeklyBoxRepository.delete(userWeeklyBox);
    }

    public void addWeeklyBoxtoTask(Long id){
        Optional<UserWeeklyBox> thistask = userWeeklyBoxRepository.findById(id);
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
        userWeeklyBoxRepository.save(userWeeklyBox);
    }

    public List<UserWeeklyBox> findAllWeeklyBox(Long userno){
        return userWeeklyBoxRepository.findAllByUserIdAndUsed(userno,true);
    }

    public void comebackWeeklyBox(){
        // task에서 찾아서 삭제하고
        // weeklybox setUsed true로
    }

    public void autoComebackWeeklyBox(){
        // 매일 0시마다
        // task에서 찾아서 삭제하고
        // weeklybox setUsed true

    }

}
