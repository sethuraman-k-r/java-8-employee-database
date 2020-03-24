package com.learn.java.repository;

import com.learn.java.models.DeptEmp;
import com.learn.java.models.DeptEmpPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpPK> {
}
