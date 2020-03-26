package com.learn.java;

import com.learn.java.services.DepartmentServices;
import com.learn.java.services.EmployeeServices;
import com.learn.java.services.SalaryServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaApplication {

	private static final Logger log = LoggerFactory.getLogger(JavaApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JavaApplication.class, args);

		EmployeeServices employeeServices = context.getBean(EmployeeServices.class);
		employeeServices.getEmployeeInfo();

		DepartmentServices departmentServices = context.getBean(DepartmentServices.class);
		departmentServices.getDeptInfo();

		SalaryServices salaryServices = context.getBean(SalaryServices.class);
		salaryServices.getSalaryInfo();
	}

}
