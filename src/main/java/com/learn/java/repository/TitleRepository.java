package com.learn.java.repository;

import com.learn.java.models.Title;
import com.learn.java.models.TitlePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title, TitlePK> {
}
