package com.example.todaytodo.Repository;


import com.example.todaytodo.Entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser,Long> {

}
