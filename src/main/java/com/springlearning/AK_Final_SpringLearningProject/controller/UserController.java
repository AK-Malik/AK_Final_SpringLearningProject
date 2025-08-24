package com.springlearning.AK_Final_SpringLearningProject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") //1
public class UserController {

    @RequestMapping(method = {RequestMethod.POST})  //2   //11 &2 can be combined here and written as @PostMapping("/users")
    public String createUser() {
     return "User created successfully!";
    }
}
