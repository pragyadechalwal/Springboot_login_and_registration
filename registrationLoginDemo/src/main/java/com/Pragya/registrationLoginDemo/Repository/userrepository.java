package com.Pragya.registrationLoginDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Pragya.registrationLoginDemo.entity.entity;

@Repository

public interface userrepository extends JpaRepository<entity,Integer> {

    entity findByUsername(String username);
    
}
