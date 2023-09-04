package com.Pragya.registrationLoginDemo.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class entity{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    private String name;
    private String username;
    private String password;
    private String gender;
    private String dob;

    @ElementCollection(targetClass = String.class)
    private List<String> technology;

    
}
