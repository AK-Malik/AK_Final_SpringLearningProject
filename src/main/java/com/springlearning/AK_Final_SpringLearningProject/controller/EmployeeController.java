package com.springlearning.AK_Final_SpringLearningProject.controller;

import com.springlearning.AK_Final_SpringLearningProject.Service.EmployeeService;
import com.springlearning.AK_Final_SpringLearningProject.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    /**
     * This class will intercept an incoming request over HTTP and call the service class to process the response and return back to the caller
     */

  @Autowired
  private EmployeeService employeeService;  //Download the object of EmployeeService from Spring IOC container
    //Define a list
    private List<EmployeeModel> empRecord = new ArrayList<>();

    //Add object in list
    @PostMapping("/addEmployeeRecord")
    public ResponseEntity<EmployeeModel> addEmployeesRecord(@RequestBody EmployeeModel addEmployeeSK) {    //@RequestBody we use for Put and POST http requests. ResponseEntity is not needed in this as we are not returning
        empRecord.add(addEmployeeSK);  // Add the EmployeeModel_SK object received thru @RequestBody in empRecord List
        System.out.println("employee Record added successfully: " + empRecord.toString());
        return new ResponseEntity<>(HttpStatus.CREATED);  //no response body returns in response entity when adding an element but HTTPStatusCode 201 so responseBody return type is updated to EmployeeModel_SK Object
    }

    @GetMapping(value = "/displayEmployeeList")
    public ResponseEntity<List<EmployeeModel>> displayEmployeeList() {   //@RequestBody we use for Put and POST http requests
        return new ResponseEntity<>(empRecord, HttpStatus.OK);
    }

    @GetMapping(value ="/getEmployeeIfMatchFound/{empId}")
    public ResponseEntity<?> getEmployeeIfMatchFound(@PathVariable("empId") Integer empId){   //This method returns an http response containing an object EmployeeResponse and
        if (empId != null) {
            System.out.println("processing the request..");
         // ResponseEntity<?> responseEntity =  employeeService.validateReturnResponse(empRecord, empId);
         // return responseEntity;
            return employeeService.validateReturnResponse(empRecord, empId); //returns the response entity object of EmployeeModel from EmployeeService Class
        } else {
            System.out.println("Invalid Request: Please submit a valid request");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    }
