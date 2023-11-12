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
import org.springframework.scheduling.annotation.Scheduled;
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
                .weeklyId(id)
                .date(now)
                .isWeeklybox(true)
                .build();
        jpaTaskRepository.save(task);

        userWeeklyBox.setUsed(false);
        userWeeklyBoxRepository.save(userWeeklyBox);
    }

    public List<UserWeeklyBox> findAllWeeklyBox(Long userno){
        return userWeeklyBoxRepository.findAllByUserIdAndUsed(userno,true);
    }

    public void comebackWeeklyBox(Long id){
        Optional<Task> object = jpaTaskRepository.findById(id);
        Task thistask = object.get();

        Optional<UserWeeklyBox> wObject = userWeeklyBoxRepository.findById(thistask.getWeeklyId());
        UserWeeklyBox thisWeeklyBox = wObject.get();
        thisWeeklyBox.setUsed(true);

        jpaTaskRepository.delete(thistask);
        userWeeklyBoxRepository.save(thisWeeklyBox);
    }

    @Scheduled(cron="0 0 0 * * *")
    public void autoComebackWeeklyBox(){
        LocalDate now = LocalDate.now().minusDays(1);
        List<Task> tasks = jpaTaskRepository.findAllByIsWeeklyBoxAndDate(true,now);
        for(Task task : tasks){
            Optional<UserWeeklyBox> wObject = userWeeklyBoxRepository.findById(task.getWeeklyId());
            UserWeeklyBox thisWeeklyBox = wObject.get();
            thisWeeklyBox.setUsed(true);

            jpaTaskRepository.delete(task);
            userWeeklyBoxRepository.save(thisWeeklyBox);
        }

    }

}
