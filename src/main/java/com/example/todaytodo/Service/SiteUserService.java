package com.example.todaytodo.Service;


import com.example.todaytodo.Dto.LoginDto;
import com.example.todaytodo.Dto.SiteUserDto;
import com.example.todaytodo.Entity.SiteUser;
import com.example.todaytodo.Entity.UserRole;
import com.example.todaytodo.Entity.WeeklyBox;
import com.example.todaytodo.Repository.SiteUserRepository;
import com.example.todaytodo.Repository.WeeklyBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SiteUserService implements UserDetailsService {
    private final SiteUserRepository siteUserRepository;
    private final WeeklyBoxRepository weeklyBoxRepository;

    private final PasswordEncoder passwordEncoder;


    LocalDate now = LocalDate.now();

    public void add(){
        Optional<SiteUser> findUser = siteUserRepository.findById(1L);
        if(!findUser.isPresent()){
            SiteUser siteUser = SiteUser.builder()
                    .userName("master")
                    .password("1234")
                    .nickname("마스터")
                    .build();

            siteUserRepository.save(siteUser);

            WeeklyBox weeklyBox = new WeeklyBox(siteUser.getUserno(),now);
            weeklyBoxRepository.save(weeklyBox);
        }
    }

    public void create(SiteUserDto siteUserDto){
        SiteUser siteUser = SiteUser.builder()
                .userName(siteUserDto.getUserName())
                .password(passwordEncoder.encode(siteUserDto.getPassword()))
                .nickname((siteUserDto.getNickname()))
                .build();
        siteUserRepository.save(siteUser);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SiteUser> _siteUser = this.siteUserRepository.findByUserName(username);
        if (_siteUser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        SiteUser siteUser = _siteUser.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new User(siteUser.getUserName(), siteUser.getPassword(), authorities);
    }

    public long findId(String username){
        Optional<SiteUser> _siteUser = siteUserRepository.findByUserName(username);
        if (_siteUser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        SiteUser siteUser = _siteUser.get();
        return siteUser.getUserno();
    }
}
