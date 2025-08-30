package com.springlearning.AK_Final_SpringLearningProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlEncoderController {

    /*
     * Hit with : Id = 1 Name = Anil,
     * POST --> http://localhost:9099/AKSpringLearning/SpringFormURLEncoded   . provide Id = 12345 and Name = Anil under x-www-form-encoded in postman
     * Both are mandatory
     * If any one of them is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
     * Key names should be strictly Id and Name
     * @RequestParam is implicitly used (if not mentioned explicitly). if no value is defined, null will be return as input id or name. if both provided url encoded and request param, both will be returned
     */
    @PostMapping("/SpringFormURLEncoded")
    public ResponseEntity<String> springFormUrlencoded(Integer Id, String Name) {
        System.out.println("in spring-form-urlencoded");
        return new ResponseEntity<>("spring-form-urlencoded : " + Id + " - " + Name, HttpStatus.OK);
    }

}
