package com.learn.java.services;

import com.learn.java.models.Salary;
import com.learn.java.models.SalaryPK;
import com.learn.java.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SalaryServices {

    @Autowired
    private SalaryRepository salaryRepository;

    public void getSalaryInfo() {
        List<Salary> salaries = salaryRepository.findLimitedSalary(1000);

        Map<Integer, Long> sumOfEmployeeSalaries = salaries.stream()
            .collect(Collectors.groupingBy(s -> s.getEmployee().getEmpNo(),
                Collectors.summingLong(Salary::getSalary)));
        System.out.println(sumOfEmployeeSalaries);

        boolean areEmployeesRicher = salaries.stream().allMatch(s -> s.getSalary() > 30000);
        if(areEmployeesRicher){
            System.out.println("Most of the employees are wealthy");
        }

        boolean areEmployeesPoorer = salaries.stream().noneMatch(s -> s.getSalary() < 10000);
        if(areEmployeesPoorer){
            System.out.println("Employees are not below poverty line");
        }

        Optional<Salary> maxPaidEmployee = salaries.stream().max(Comparator.comparingInt(Salary::getSalary));
        System.out.println("Highest Paid Employee : " + maxPaidEmployee.get().getEmployee().getFirstName());

        Optional<Salary> minPaidEmployee = salaries.stream().min(Comparator.comparingInt(Salary::getSalary));
        System.out.println("Lowest Paid Employee : " + minPaidEmployee.get().getEmployee().getFirstName());

        List<Map.Entry<Integer, Integer>> employeeWithTheirOwnHighestPay = salaries.stream()
                .collect(Collectors.groupingBy(s -> s.getEmployee().getEmpNo(),
                        Collectors.collectingAndThen(
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Salary::getSalary)),
                                        Optional::get),
                                Salary::getSalary
                        )
                )).entrySet()
                .stream()
                .sorted((s1, s2) -> s1.getValue().compareTo(s2.getValue()))
                .collect(Collectors.toList());
        System.out.println("Employees with their highest salary among all their salaries : " + employeeWithTheirOwnHighestPay);
    }

}
