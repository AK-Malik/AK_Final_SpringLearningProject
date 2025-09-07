package com.springlearning.AK_Final_SpringLearningProject.Service;
import com.springlearning.AK_Final_SpringLearningProject.model.EmployeeModel;
import com.springlearning.AK_Final_SpringLearningProject.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service      //Will create an object of EmployeeService and store in Spring IOC container. implementing class can use @Autowired to download it from IOC Container
public class EmployeeService {
    public ResponseEntity<?> validateReturnResponse(List<EmployeeModel> empRecord, Integer empId) {

        if (empRecord.size() != 0) {
            for (EmployeeModel emp : empRecord) {    //EmployeeModel emp = null; for (int i = 0; i < empRecord.size(); i++) { emp = empRecord.get(i);
                if (emp.getEmpId().equals(empId)) {
                    System.out.println("Requested empId is :" + emp.getEmpId() + ":" + emp.getEmpName() + "And List Object:" + emp);
                    return new ResponseEntity<>(emp, HttpStatus.OK);    //returns an object of EmployeeModel
                }
            }
        }
        System.out.println("Match Not Found in EmployeeRecord List for employeeId: " + empId);
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setHttpErrorCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setErrorMessage("Data Not Found...");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);  //returns a ResponseEntity object of type ErrorResponse
    }
}


