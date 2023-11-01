package com.example.todaytodo.Service;


import com.example.todaytodo.Entity.SiteUser;
import com.example.todaytodo.Entity.WeeklyBox;
import com.example.todaytodo.Repository.SiteUserRepository;
import com.example.todaytodo.Repository.WeeklyBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;
    private final WeeklyBoxRepository weeklyBoxRepository;

    LocalDate now = LocalDate.now();

    public void add(){
        Optional<SiteUser> findUser = siteUserRepository.findById(1L);
        if(!findUser.isPresent()){
            SiteUser siteUser = SiteUser.builder()
                    .id("master")
                    .password("1234")
                    .nickname("마스터")
                    .build();

            siteUserRepository.save(siteUser);

            WeeklyBox weeklyBox = new WeeklyBox(siteUser.getUserno(),now);
            weeklyBoxRepository.save(weeklyBox);
        }
    }
}
