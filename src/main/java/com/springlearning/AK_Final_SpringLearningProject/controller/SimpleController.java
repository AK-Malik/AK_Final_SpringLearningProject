package com.springlearning.AK_Final_SpringLearningProject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleController {

     /**
      *  External call begin from controller.  API Learning Thru Spring and Testing begins here
      *  run the end point in the postman or similar tool like: method type: GET:  <a href="http://localhost:9099/AKSpringLearning/getMyMessage">...</a>
      *  GET http://localhost:9099/AKSpringLearning/getMyMessage    (port and context, defined in application.properties
      */

    @GetMapping("/getMyMessage")
    public String getCustomMessage() //method name doesn't matter as long as mapping is correct
    {
        System.out.println("Printing, getMessage defined under SimpleController class "); //this will be print in app logs
        return "Success - I'm inside getMessage of SimpleController class";  //this will be returned in the postman
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
