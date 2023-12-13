package com.example.todaytodo.Repository;

import com.example.todaytodo.Entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatisticsRepository extends JpaRepository<Statistics,Long> {
    Optional<Statistics> findByUserno(long userno);
}
