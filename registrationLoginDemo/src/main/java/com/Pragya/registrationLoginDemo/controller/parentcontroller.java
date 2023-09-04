package com.Pragya.registrationLoginDemo.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Pragya.registrationLoginDemo.Repository.userrepository;
import com.Pragya.registrationLoginDemo.entity.entity;

@Controller
public class parentcontroller{
    @Autowired
    private userrepository ur;

    @GetMapping("/")
    public String show(){
        return "home";
    }

    @GetMapping("/registration")
    public String registrationPage(entity entity){
        return "registration";
    }
    @GetMapping("/login")
    public String loginPage(entity entity){
        return "login";
    }
    @PostMapping("/register")
    @ResponseBody
    public String register(@ModelAttribute("entity") entity entity){
        String hash= BCrypt.hashpw(entity.getPassword(),BCrypt.gensalt(12));
        entity.setPassword(hash);
        ur.save(entity);
        System.out.println(entity);
        return "Data saved successfully";
    }

     @PostMapping("/loginprocess")
     @ResponseBody
    public String loginProcess(@RequestParam("username") String username,@RequestParam("password") String password){
     entity user = ur.findByUsername(username);
     Boolean isPasswordMatch = BCrypt.checkpw(password,user.getPassword());
     if(isPasswordMatch){
        return "welcome";
     }
     else{
        return "error in login";
     }


    }



    
}
