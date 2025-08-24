package com.springlearning.AK_Final_SpringLearningProject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Repository
public class SimpleDaoClass {
   public String getAMessage()
    {
        System.out.println("A get message from SimpleDaoClass's getAMessage()");
        return "Success - A get message from SimpleDaoClass's getAMessage()";
    }

    public String postAMessage()
    {
        System.out.println("postAMessage from SimpleDaoClass's postAMessage()");
        return "Success - postAMessage from SimpleDaoClass's postAMessage()";
    }

}
