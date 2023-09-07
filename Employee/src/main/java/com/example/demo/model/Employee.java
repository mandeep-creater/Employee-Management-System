package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private String state;
    private String type;
    private double salary;
    private String Email;
    private String dept;
     

    //constructor

     public Employee() {
   
    }

          //Getter Setter

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public double getSalary() {
        return salary;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String getEmail() {
        return Email;
    }


    public void setEmail(String email) {
        Email = email;
    }


    public String getDept() {
        return dept;
    }


    public void setDept(String dept) {
        this.dept = dept;
    }

      
    // Parameterized Constructor 

    public Employee(int id, String name, int age, String state, String type, double salary, String email, String dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.state = state;
        this.type = type;
        this.salary = salary;
        Email = email;
        this.dept = dept;
    }
    
   

    
}
