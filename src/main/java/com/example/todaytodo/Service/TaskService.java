package com.example.todaytodo.Service;

import com.example.todaytodo.Dto.TaskDto;
import com.example.todaytodo.Entity.Statistics;
import com.example.todaytodo.Entity.Task;
import com.example.todaytodo.Repository.JpaTaskRepository;
import com.example.todaytodo.Repository.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final JpaTaskRepository jpaTaskRepository;
    private final StatisticsRepository statisticsRepository;

    LocalDate now = LocalDate.now();

    public void addTask(TaskDto taskDto,long userno){
        Task newtask = Task.builder()
                .task(taskDto.getTask())
                .preferencePoint(taskDto.getPreference_point())
                .importancePoint(taskDto.getImportance_point())
                .date(now)
                .userno(userno)
                .build();
        System.out.println(taskDto.getTask());
        jpaTaskRepository.save(newtask);
    }

    public List<Task> findAllTask(LocalDate dateInfo,long userno){
        return jpaTaskRepository.findAllByDateAndUserno(dateInfo,userno);
    }

    public void deleteTask(long id){
        Task thistask = findTask(id);
        jpaTaskRepository.delete(thistask);
    }

    public void postponeTask(long id,LocalDate dateInfo,long userno){
        Task thistask = findTask(id);

        LocalDate next = dateInfo.plusDays(1);
        thistask.setDate(next);

//        Optional<Statistics> _statistics = statisticsRepository.findByUserno(userno);
//        if(_statistics.isEmpty()){
//            throw new RuntimeException();
//        }
//        Statistics statistics = _statistics.get();
//        long count = statistics.getPostpone();
//        statistics.setPostpone(count++);
//        statisticsRepository.save(statistics);

        jpaTaskRepository.save(thistask);
    }

    public List<Task> orderByPreference(){
        return jpaTaskRepository.findAllByDateOrderByPreferencePoint(now);
    }

    public List<Task> orderByImportance(){
        return jpaTaskRepository.findAllByDateOrderByImportancePoint(now);
    }

    public long todayAchievement(long userno){
        Long done = jpaTaskRepository.countByDoneAndUsernoAndDate(true,userno,now);
        Long all = jpaTaskRepository.countByUsernoAndDate(userno,now);
        if(all==0){
            return 0;
        }
        return done/all*100;
    }

    public Long countPostpone(long userno){
        Optional<Statistics> _statistics = statisticsRepository.findByUserno(userno);
        Statistics statistics = _statistics.get();
        return statistics.getPostpone();
    }

    public Long totalAchievement(long userno){
        Long done = jpaTaskRepository.countByDoneAndUserno(true, userno);
        Long all = jpaTaskRepository.countByUserno(userno);
        return done/all*100;
    }

    public void doneTask(long id){
        Task task = findTask(id);

        task.setDone(true);

        jpaTaskRepository.save(task);
    }

    public Task findTask(long id){
        Optional<Task> object = jpaTaskRepository.findById(id);
        if(object.isPresent()){
            return object.get();
        }
        return null;
    }



}
