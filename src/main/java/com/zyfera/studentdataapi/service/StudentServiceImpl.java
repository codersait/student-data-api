package com.zyfera.studentdataapi.service;

import org.springframework.stereotype.Service;

import com.zyfera.studentdataapi.entity.Student;
import com.zyfera.studentdataapi.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

}
