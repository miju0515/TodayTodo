package com.example.todaytodo.Service;

import com.example.todaytodo.Dto.TaskDto;
import com.example.todaytodo.Entity.Task;
import com.example.todaytodo.Repository.JpaTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final JpaTaskRepository jpaTaskRepository;

    LocalDate now = LocalDate.now();

    public void addTask(TaskDto taskDto){
        Task newtask = Task.builder()
                .task(taskDto.getTask())
                .preferencePoint(taskDto.getPreference_point())
                .importancePoint(taskDto.getImportance_point())
                .date(now)
                .build();
        System.out.println(taskDto.getTask());
        jpaTaskRepository.save(newtask);
    }

    public List<Task> findAllTask(){
        return jpaTaskRepository.findAllByDate(now);
    }

    public void deleteTask(long id){
        Optional<Task> object = jpaTaskRepository.findById(id);
        Task thistask = object.get();
        jpaTaskRepository.delete(thistask);
    }

    public void postponeTask(long id){
        Optional<Task> object = jpaTaskRepository.findById(id);
        Task thistask = object.get();

        LocalDate next = now.plusDays(1);
        thistask.setDate(next);

        jpaTaskRepository.save(thistask);
    }

    public List<Task> orderByPreference(){
        return jpaTaskRepository.findAllByDateOrderByPreferencePoint(now);
    }

    public List<Task> orderByImportance(){
        return jpaTaskRepository.findAllByDateOrderByImportancePoint(now);
    }

    public Long todayAchievement(){
        Long done = jpaTaskRepository.countByIsDone(true);
        Long all = jpaTaskRepository.count();

        return done/all*100;
    }


}
