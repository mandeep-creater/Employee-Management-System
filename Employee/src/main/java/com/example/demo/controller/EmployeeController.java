package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.serviceIMPL.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/home")
    public String homepage()
    {
        return "Welcome To Employee Management System"; 
    }


    @PostMapping("/addEmp")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) 
    {
        Employee emp = employeeService.addEmployee(employee);

        return new ResponseEntity<Employee>(emp , HttpStatus.CREATED);
    }
    
    @DeleteMapping("/removeEmp/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable int id)
    {
        employeeService.removeEmployee(id);
        return new ResponseEntity<String> ("Remove Successfully" , HttpStatus.ACCEPTED);
    }

    @GetMapping("/findEmp/{id}")
    public ResponseEntity<Optional<Employee>> findEmployeeById(@PathVariable int id)
    {
        Optional<Employee> emps = employeeService.findEmpById(id);

        return new ResponseEntity<Optional<Employee>>(emps , HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity <List<Employee>> listOfEmployee()
    {
        List<Employee> AllEmp = employeeService.getAllEmployee();

        return new ResponseEntity <List<Employee>> (AllEmp,HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployeeField(
        @PathVariable int id,
        @RequestBody Map<String, String> requestParams
    ) {
        String fieldName = requestParams.get("fieldName");
        String newValue = requestParams.get("newValue");

        if (fieldName == null || newValue == null) {
            return ResponseEntity.badRequest().body("fieldName and/or newValue missing in the request body.");
        }

        String result = employeeService.updateEmployee(id, fieldName, newValue);
        if (result.equals("Employee field updated successfully!")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
    
   
    }
   


