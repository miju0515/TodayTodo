package com.example.todaytodo.Repository;

import com.example.todaytodo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTaskRepository extends JpaRepository<Task,Long> {
}
