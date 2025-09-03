/**
 * This also demonstrate the CRUD operation over an ArrayList
 */
package com.springlearning.AK_Final_SpringLearningProject.controller;

import com.springlearning.AK_Final_SpringLearningProject.model.EmployeeModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeNameController {
    /**
     *     Create a list to be used in the entire program. The scope of this ArrayList is persisting until app is running.it keeps the data in RAM
     */

    private List<EmployeeModel> empList = new ArrayList<EmployeeModel>();

    /**
     * pass an inputs in JSON format under body in Postman and store/add in ArrayList of EmployeeModel
     * conversion from JSON/XML to pojo -- De-serialization (Un-marshalling)
     * conversion from POJO to JSON/XML -- serialization (Marshalling)
     * get  request: http status: 200, if record is insert (post), httpStatus : 201
     * update/delete request: http status Accepted - code: 202,
     */

    /**
     * Add EmployeeModel Object in EmpList List
     * @param addEmployee
     * @return
     * /@RequestBody we use for Put and POST http requests
     * Run as POST : http://localhost:9099/AKSpringLearning/addEmployeeInList
     */

    @PostMapping("/addEmployeeInList")
    //public ResponseEntity<List<EmployeeModel>> addEmployees(@RequestBody EmployeeModel addEmployee) {  //passed the request body from http request which will be converted into EmployeeModel POJO
    public ResponseEntity<EmployeeModel> addEmployees(@RequestBody EmployeeModel addEmployee) {    //@RequestBody we use for Put and POST http requests
        empList.add(addEmployee);  // Add the EmployeeModel object received thru @RequestBody in empList
        System.out.println("employee added successfully: " + empList.toString());
        //System.out.println("employee added successfully: " + empList);    //this works same as above line & prints same output. Prints toString() of pojo class. if no toString() in POJO class then it will print hashcode value of the pojo class object
        return new ResponseEntity<>(HttpStatus.CREATED);  //no response body returns in response entity when adding an element but HTTPStatusCode 201 so responseBody return type is updated to EmployeeModel Object
    }

    /**
     * Get/Fetch the element/objects from ArrayList
     * Run it HTTP GET : http://localhost:9099/AKSpringLearning/getEmployee
     * @return empList, HTTP status code = 200
     */
    @GetMapping(value = "/getEmployee")
    public ResponseEntity<List<EmployeeModel>> getEmployeeList() {   //@RequestBody we use for Put and POST http requests
        return new ResponseEntity<>(empList, HttpStatus.OK);
    }

    /**
     * Retrieve/fetch an element from EmpList using an EmpId (provide empId under path variable) , returns a single object
     * run as: http://localhost:9099/AKSpringLearning/getEmployee/{empId}   //replace{empId} with whateever empId in list we have e.g. 101
     */
    @RequestMapping(value = "/getEmployee/{empId}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeModel> getEmployees(@PathVariable Integer empId ) {
        EmployeeModel result = null;
        for (EmployeeModel emp : empList) {          //for (int i = 0; i < empList.size(); i++) {  EmployeeModel emp = empList.get(i);  if (emp.getEmpId().equals(empId)) {  // your logic here   }    }
            if (emp.getEmpId().equals(empId)) {
                System.out.println("Requested empId is :" + emp.getEmpId() + ":" + empId);
                result = emp;
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * updateEmployee(provide the updated json), using pathVariable
     * Run as HTTP PUT using :  http://localhost:9099/AKSpringLearning/updateEmployee/{empId}  //http://localhost:9099/AKSpringLearning/updateEmployee/101
     * @param
     */

    @PutMapping("/updateEmployee/{empId}")
    public ResponseEntity<EmployeeModel> updateAnEmployee(@PathVariable Integer empId, @RequestBody EmployeeModel updateEmployee) {
    //public ResponseEntity<> updateAnEmployee(@PathVariable Integer empId, @RequestBody EmployeeModel updateEmployee) {
           for (EmployeeModel emp : empList) {
            if (emp.getEmpId().equals(empId)) {
                emp.setEmpName(updateEmployee.getEmpName());
                System.out.println("Employee updated successfully: "+ emp );
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    /**
     * Delete An Employee using path variable
     * Run as HTTP Delete using :  http://localhost:9099/AKSpringLearning/deleteAnEmployee/{empId}
     * @param empId
     * @param updateEmployee
     * @return
     */
    @DeleteMapping("/deleteEmployee/{empId}")
    public ResponseEntity deleteAnEmployee(@PathVariable Integer empId, @RequestBody EmployeeModel updateEmployee) {
    //public ResponseEntity deleteAnEmployee(@PathVariable Integer empId, @RequestBody EmployeeModel updateEmployee)
        for (EmployeeModel emp : empList) {
            if (emp.getEmpId().equals(empId)) {
                empList.remove(emp);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED); //202
    }


/**
**************************** More Trials ***********
*/

 /**
 * Run it HTTP GET : http://localhost:9099/AKSpringLearning/employeeList
 * @return
 */

@GetMapping(value = "/employeeList")
public ResponseEntity<List<EmployeeModel>> employeeList() {   //@RequestBody we use for Put and POST http requests
    List<EmployeeModel> employeeList = new ArrayList<>();
    // Add elements to the list
    employeeList.add(new EmployeeModel(123, "AK"));
    employeeList.add(new EmployeeModel(234, "SK"));
    employeeList.add(new EmployeeModel(345, "NZ"));
    employeeList.add(new EmployeeModel(456, "AM"));
    employeeList.add(new EmployeeModel(567, "SM"));
    System.out.println("employeeList set/created Successfully: " + employeeList);   // Place before return statement
    return new ResponseEntity<List<EmployeeModel>>(employeeList, HttpStatus.OK);
}

    /**
     * prints an EmployeeList
     * run as Get : http://localhost:9099/AKSpringLearning/getAnEmployee
     */
    @RequestMapping(value = "/getAnEmployee", method = RequestMethod.GET)
    public ResponseEntity<EmployeeModel> getAnEmployees() {
        List<EmployeeModel> employeeList2 = new ArrayList<>();
        // Add elements to the list
        employeeList2.add(new EmployeeModel(1, "AK"));
        employeeList2.add(new EmployeeModel(2, "SK"));
        employeeList2.add(new EmployeeModel(3, "NZ"));
        employeeList2.add(new EmployeeModel(4, "AM"));
        employeeList2.add(new EmployeeModel(5, "SM"));
        System.out.println("My employeeList2 is : " + employeeList2);
        // Find employee by empId
        EmployeeModel emp = null;
         for (int i = 0; i < employeeList2.size(); i++) {
              emp = employeeList2.get(i);
             System.out.println("Retrieve employeeList2 elements :" + emp + ":-:" + emp.getEmpId() + ":--:" + emp.getEmpName());
             // Return the first employee as an example
             return new ResponseEntity<>(employeeList2.getFirst(), HttpStatus.OK);
         }
//Enhanced For Loop
//        for (EmployeeModel emp : employeeList2) {
//            System.out.println("Retrieve employeeList2 elements :" + emp + ":-:" + emp.getEmpId() + ":--:" + emp.getEmpName());
//        }
        System.out.println("Retrieve employeeList2 elements :" + emp );
        return new ResponseEntity<EmployeeModel>(emp, HttpStatus.OK);
     }


}