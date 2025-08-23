package com.springlearning.AK_Final_SpringLearningProject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {

    //--------API Learning Thru Spring and Testing begins here-------------//

    @GetMapping("/getMyMessage")
    public String getCustomMessage()
    {
        System.out.println("Printing, getMessage defined under SimpleController class ");
        return "Success - I'm inside getMessage of SimpleController class";
    }

    @PostMapping("/postMyMessage")
    public String postMessage()
    {
        System.out.println("Printing postMessage under SimpleController class");
        return "Success - I am in SimpleController.java's postMessage" ;
    }
    @PutMapping("/putMyMessage")
    public String putMessage()
    {
        System.out.println("Printing puMessage under SimpleController class");
        return "Success - I am in SimpleController.java's puMessage" ;
    }
    @PatchMapping("/patchMyMessage")
    public String patchMessage()
    {
        System.out.println("printing patching from SimpleController class");
        return "Success - I am in SimpleController.java's patchMessage" ;
    }
    @DeleteMapping("/deleteMyMessage")
    public String deleteMessage()
    {
        System.out.println("Printing deleteMyMessage under SimpleController class");
        return "Success - I'm in SimpleController.java class's deleteMessage";
    }

}
