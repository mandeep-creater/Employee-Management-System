package com.example.demo.serviceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;        // Reference of Employee Repository

    @Override
    public Employee addEmployee(Employee employee) {
        
        Employee emp = employeeRepo.save(employee); //adding data
        
        return emp;
    }

    @Override
    public String removeEmployee(int id) {

       employeeRepo.deleteById(id);     //deleting data

         return " Delete Employee Data Sucessfully";
    }

    @Override
    public Optional<Employee> findEmpById(int id) {
      
       Optional<Employee> emp = employeeRepo.findById(id);
       if(emp.isPresent())
       {
        return emp;
       }
        else{
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        
        List<Employee> emplist= (List<Employee>) employeeRepo.findAll();

        return emplist;
    }

    @Override
    public String updateEmployee(int id, String fieldName, String newValue) {
        Optional<Employee> empOptional = employeeRepo.findById(id);
    
        if (empOptional.isPresent()) {
            Employee existingEmployee = empOptional.get();
    
            // Update the specified field with the new value
            switch (fieldName.toLowerCase()) {
                case "name":
                    existingEmployee.setName(newValue);
                    break;
                case "age":
                    existingEmployee.setAge(Integer.parseInt(newValue));
                    break;
                case "state":
                    existingEmployee.setState(newValue);
                    break;
                case "type":
                    existingEmployee.setType(newValue);
                    break;
                case "salary":
                    existingEmployee.setSalary(Double.parseDouble(newValue));
                    break;
                case "email":
                    existingEmployee.setEmail(newValue);
                    break;
                case "dept":
                    existingEmployee.setDept(newValue);
                    break;
                default:
                    return "Invalid field name";
            }
    
            employeeRepo.save(existingEmployee);
            return "Employee field updated successfully!";
        } else {
            return "Employee not found";
        }
    }
    

   
 
}

    
    

