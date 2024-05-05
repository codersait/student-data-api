package com.zyfera.studentdataapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zyfera.studentdataapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
