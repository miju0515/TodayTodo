package com.example.todaytodo.Repository;

import com.example.todaytodo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JpaTaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAllByIsWeeklyBoxAndDate(boolean isWeeklyBox, LocalDate now);

    List<Task> findAllByDateOrderByPreferencePoint(LocalDate now);

    List<Task> findAllByDateOrderByImportancePoint(LocalDate now);

    Long countByIsDone(boolean isdone);

    List<Task> findAllByDate(LocalDate now);
}
