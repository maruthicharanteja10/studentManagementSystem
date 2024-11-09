package com.projects.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.springboot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
