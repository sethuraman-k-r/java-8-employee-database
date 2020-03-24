package com.learn.java.repository;

import com.learn.java.models.DeptManager;
import com.learn.java.models.DeptManagerPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptManagerPK> {
}
