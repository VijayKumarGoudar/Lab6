package com.greatlearning.lab6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.lab6.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
