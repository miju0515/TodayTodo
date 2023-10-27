package com.example.todaytodo.Service;

import com.example.todaytodo.Entity.SiteUser;
import com.example.todaytodo.Repository.SiteUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SiteUserService {
    private final SiteUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser join(String id, String password, String nickname){
        SiteUser user = SiteUser.builder()
                .id(id)
                .password(passwordEncoder.encode(password))
                .nickname(nickname)
                .build();
        userRepository.save(user);
        return user;
    }
}
