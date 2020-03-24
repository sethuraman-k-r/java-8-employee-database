package com.learn.java.services;

import com.learn.java.models.Employee;
import com.learn.java.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void genderWiseEmployeeCategory(){
        List<Employee> employees = employeeRepository.findAll();
        Long totalMaleEmployees = employees.stream().filter(e -> e.getGender().equalsIgnoreCase("M")).count();
        System.out.println("Total Male Employees : " + totalMaleEmployees);
        Long totalFemaleEmployees = employees.stream().filter(e -> e.getGender().equalsIgnoreCase("F")).count();
        System.out.println("Total Female Employees : " + totalFemaleEmployees);
    }

    public void calculateEmployeeExperiences() {
        List<Employee> employees = employeeRepository.findAll();
        employees.stream()
                .map(e -> e.getHireDate())
                .forEach(System.out::println);
    }

}
