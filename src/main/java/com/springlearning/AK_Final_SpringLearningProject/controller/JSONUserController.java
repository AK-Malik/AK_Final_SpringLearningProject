package com.springlearning.AK_Final_SpringLearningProject.controller;

import com.springlearning.AK_Final_SpringLearningProject.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.ArrayList;

@RestController
//@RequestMapping("/users") //1
public class JSONUserController {

   // private ArrayList<UseStringrModel> userModels = new arralys
    /*
     * POST --> http://localhost:9099/AKSpringLearning/springJsonExample/users
     * Hit with JSON format of UserModel object
     * If JSON body is not provided then exception will be thrown with 415(unsupported Media Type) as ResponseCode
     * If some fields are missing from JSON body and its a valid JSON, then the JSON will be absorbed but the missing fields will be assigned as null
     */
//http://localhost:9099/AKSpringLearning/springJson/createUserA
    @GetMapping(value = "/springJson/createUserA")
    //public ResponseEntity<UserModel> springJSON(@RequestBody UserModel userModel ){
    public ResponseEntity<UserModel> springJSON() {
       // userModels.add(name)
        UserModel userModel = new UserModel(1, "Anil", "ak@test.com", "Panipat");
        System.out.println("spring-JSON Example - UserCreated Successfully");
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

    //Run as : http://localhost:9099/AKSpringLearning/springJson/createUserB

    //@GetMapping(value = "/springJson/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/springJson/createUserB",produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<UserModel> springJSONExample() {
        UserModel userModel = new UserModel(2, "Anil", "ak@test.com", "Panipat");
        System.out.println("spring-JSON Example - UserCreated Successfully");
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }


    @GetMapping(value = "/springJson/createUserC", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserModel> springJSONExampleS() {
        UserModel userModel = new UserModel(3, "Anil", "ak@test.com", "Panipat");
        System.out.println("spring-JSON Example - UserCreated Successfully");
        return new ResponseEntity<>(userModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = {RequestMethod.POST})  //2   //11 &2 can be combined here and written as @PostMapping("/users")
    @PostMapping("//springJson/getUsersById/{id}")
    public ResponseEntity<?> getUserFromUserModel(@PathVariable int id) {   //? because we are returning multivalue - String and object
        if (id == 2) {
            UserModel userModel = new UserModel(2, "Anil-Kumar", "ak@test.com", "NewJersey");
            return new ResponseEntity<String>("User Found for: " + id + "is:" + userModel, HttpStatus.valueOf(200));
        } else {
            //Example for handling not found scenario
            return new ResponseEntity<UserModel>(new UserModel(0, null, null, "User not found."), HttpStatus.NOT_FOUND); // Returns 404 Not Found
               }
       }
}

