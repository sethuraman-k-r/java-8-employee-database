package com.learn.java.services;

import com.learn.java.models.Department;
import com.learn.java.models.DeptEmp;
import com.learn.java.models.DeptManager;
import com.learn.java.repository.DepartmentRepository;
import com.learn.java.repository.DeptEmpRepository;
import com.learn.java.repository.DeptManagerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServices {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DeptManagerRepository deptManagerRepository;

    @Autowired
    private DeptEmpRepository deptEmpRepository;

    public void getDeptInfo() {
        List<Department> departments = departmentRepository.findAll();

        Map<String, String> deptDetails = new HashMap<>();
        departments.stream().forEach(d -> deptDetails.putIfAbsent(d.getDeptNo(), d.getDeptName()));
        System.out.println("Department No. and Name : " + deptDetails);

        List<DeptManager> deptManagers = deptManagerRepository.findAll();

        Map<Department, List<String>> deptMgrDetails = new HashMap<>();
        deptMgrDetails = deptManagers.stream()
                .collect(Collectors.groupingBy(DeptManager::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.mapping(dm -> dm.getEmployee().getFirstName(),
                                        Collectors.toList()),
                                Collections::synchronizedList
                        )
                ));
        System.out.println("Department No. and its Managers : " + deptMgrDetails);

        List<DeptEmp> deptEmps = deptEmpRepository.findAll();

        Map<Department, Long> deptEmpsCount = deptEmps.stream().collect(Collectors.groupingBy(
                DeptEmp::getDepartment,
                Collectors.counting()
        ));
        System.out.println("Department No. and its Employees count : " + deptEmpsCount);
    }

}
