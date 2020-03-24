package com.learn.java.services;

import com.learn.java.models.Employee;
import com.learn.java.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.stream.Collectors;

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

        Long experiencedEmployees = employees.stream()
                .map(e -> Period.between(
                        new Date(e.getHireDate().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        LocalDate.now()))
                .map(p -> p.getYears())
                .filter(e -> e >= 35)
                .count();
        System.out.println("Employees who experienced more than 35 years : " + experiencedEmployees);

        Long seniorCitizensCount = employees.stream()
                .map(e -> Period.between(
                        new Date(e.getBirthDate().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        LocalDate.now()))
                .map(p -> p.getYears())
                .filter(e -> e >= 60)
                .count();
        System.out.println("Total Senior Citizens : " + seniorCitizensCount);

        Map<String, Long> seniorCitizensCategoryWise = employees.stream()
                .filter((Employee employee) -> {
                    Integer sixtyAge = Period.between(
                            new Date(employee.getBirthDate().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                            LocalDate.now()).getYears();
                    return sixtyAge >= 60;
                }).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Total Male Senior Citizens : " + seniorCitizensCategoryWise.getOrDefault("M", 0L));
        System.out.println("Total Female Senior Citizens : " + seniorCitizensCategoryWise.getOrDefault("F", 0L));

        System.out.println("Top Ten Repeated Names : ");
//        List<Map.Entry<String, Long>> topTenRepeatedNames
         employees.stream()
                    .collect(Collectors.groupingBy(Employee::getFirstName,
                            Collectors.counting())
                    ).entrySet()
                    .stream()
                    .collect(Collectors.toList())
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .limit(10)
                    .forEach(System.out::println);
    }

}
