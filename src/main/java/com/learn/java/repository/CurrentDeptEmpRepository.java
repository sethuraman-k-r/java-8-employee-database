package com.learn.java.repository;

import com.learn.java.models.CurrentDeptEmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentDeptEmpRepository extends JpaRepository<CurrentDeptEmp, String> {
}
