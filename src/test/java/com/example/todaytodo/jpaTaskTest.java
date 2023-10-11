package com.example.todaytodo;

import com.example.todaytodo.Entity.Task;
import com.example.todaytodo.Repository.JpaTaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
//@SpringBootTest
public class jpaTaskTest {

    private JpaTaskRepository jpaTaskRepository;

    @Test
    @DisplayName("할일추가확인")
    void addTask(){
        Task t1 = Task.builder()
                .task("이것")
                .preference_point(1)
                .importance_point(2)
                .date(LocalDate.now())
                .build();
        jpaTaskRepository.save(t1);

        Optional<Task> o1 = jpaTaskRepository.findById(1L);
        if(o1.isPresent()){
            Task t2 = o1.get();
            assertEquals("이것",t2.getTask());
        }
    }
}
