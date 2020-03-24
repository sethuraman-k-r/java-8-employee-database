package com.learn.java.repository;

import com.learn.java.models.Salary;
import com.learn.java.models.SalaryPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, SalaryPK> {
}
