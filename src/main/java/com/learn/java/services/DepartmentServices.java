package com.learn.java.services;

import com.learn.java.models.Department;
import com.learn.java.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServices {

    @Autowired
    private DepartmentRepository departmentRepository;

    public void showDepartments() {
        Map<String, String> deptDetails = new HashMap<>();
        List<Department> departments = departmentRepository.findAll();
        departments.stream().forEach(d -> deptDetails.putIfAbsent(d.getDeptNo(), d.getDeptName()));
    }

}
