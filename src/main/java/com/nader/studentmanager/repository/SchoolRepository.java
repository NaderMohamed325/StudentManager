package com.nader.studentmanager.repository;

import com.nader.studentmanager.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SchoolRepository extends JpaRepository<School, Long> {


}
