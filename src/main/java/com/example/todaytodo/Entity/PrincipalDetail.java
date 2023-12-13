package com.example.todaytodo.Entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class PrincipalDetail implements UserDetails {
    private SiteUser siteUser;

    public PrincipalDetail(SiteUser siteUser){
        this.siteUser=siteUser;
    }

    @Override
    public String getPassword(){
        return siteUser.getPassword();
    }

    @Override
    public String getUsername(){
        return siteUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(() -> {
            return "UserRole";
        });
        return collectors;
    }


}
