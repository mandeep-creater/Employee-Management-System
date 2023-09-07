package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmployeeService {
    
    //adding employee
    public Employee addEmployee(Employee employee);

    //remove Employee
    public String removeEmployee(int id);

    //find BY Id
    public Optional<Employee> findEmpById(int id);

    //get all employees
    public List<Employee> getAllEmployee();

    // Update Employee
    public String updateEmployee(int id, String fieldName, String newValue);
   // public String updateEmployee(int id,Employee emp);


}
