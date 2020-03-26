package com.learn.java.repository;

import com.learn.java.models.Salary;
import com.learn.java.models.SalaryPK;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, SalaryPK> {

    @Query(value = "SELECT * FROM salaries LIMIT 0, :limit",
    nativeQuery = true)
    List<Salary> findLimitedSalary(@Param("limit") Integer limit);

}
