package com.learn.java;

import com.learn.java.models.Department;
import com.learn.java.models.DeptManager;
import com.learn.java.repository.DepartmentRepository;
import com.learn.java.repository.DeptManagerRepository;
import com.learn.java.services.DepartmentServices;
import com.learn.java.services.EmployeeServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaApplication {

	private static final Logger log = LoggerFactory.getLogger(JavaApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JavaApplication.class, args);
//		DepartmentServices departmentServices = context.getBean(DepartmentServices.class);
//		departmentServices.showDepartments();

		EmployeeServices employeeServices = context.getBean(EmployeeServices.class);
//		employeeServices.genderWiseEmployeeCategory();
		employeeServices.calculateEmployeeExperiences();
	}

}