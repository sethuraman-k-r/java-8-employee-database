package com.learn.java.repository;

import com.learn.java.models.DeptEmpLatestDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptEmpLatestDateRepository extends JpaRepository<DeptEmpLatestDate, Integer> {
}
