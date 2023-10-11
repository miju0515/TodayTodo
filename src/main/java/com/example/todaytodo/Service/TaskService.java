package com.example.todaytodo.Service;

import com.example.todaytodo.Dto.TaskDto;
import com.example.todaytodo.Entity.Task;
import com.example.todaytodo.Repository.JpaTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final JpaTaskRepository jpaTaskRepository;

    LocalDate now = LocalDate.now();

    public void addTask(TaskDto taskDto){
        Task newtask = Task.builder()
                .task(taskDto.getTask())
                .preference_point(taskDto.getPreference_point())
                .importance_point(taskDto.getImportance_point())
                .date(now)
                .build();
        jpaTaskRepository.save(newtask);
    }
}
