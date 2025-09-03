package com.springlearning.AK_Final_SpringLearningProject.model;

import java.util.Objects;

public class EmployeeModel {

    Integer empId;
    String empName;

    public Integer getEmpId() {
        return empId;
    }
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public EmployeeModel(Integer empId, String empName) {
        this.empId = empId;
        this.empName = empName;
        //System.out.println("Inputs received in employeeModel POJO - employeeModel Created :"+empId+"-"+empName); //empId or getEmpId() both works
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeModel that = (EmployeeModel) o;
        return Objects.equals(empId, that.empId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(empId);
    }

    @Override
    public String toString() {
        return "EmployeeModel: [ empId: "+empId+", empName: "+empName+" ]";
    }
}
