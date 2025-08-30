package com.springlearning.AK_Final_SpringLearningProject.Service;

import org.springframework.stereotype.Repository;

@Repository
public class SimpleService
{
    public String getAMessage()
    {
        System.out.println("A get message from SimpleService's getAMessage()");
        return "Success - A get message from SimpleService's getAMessage()";
    }

    public String postAMessage()
    {
        System.out.println("postAMessage from SimpleService's postAMessage()");
        return "Success - postAMessage from SimpleService's postAMessage()";
    }
}
