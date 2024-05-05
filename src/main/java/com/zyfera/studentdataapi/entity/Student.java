package com.zyfera.studentdataapi.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Surname is mandatory")
    private String surname;
    @NotBlank(message = "Student Number is mandatory")
    @Pattern(regexp = "^[B][0-9A-Za-z]{9}$", message = "Invalid student number format (must start with B and contain 9 alphanumeric characters)")
    private String stdNumber;

    @Valid
    @ElementCollection
    @CollectionTable(name = "student_grades")
    private List<Grade> grades;

    public Student() {
    }

    public Student(Long id, String name, String surname, String stdNumber, List<Grade> grades) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.stdNumber = stdNumber;
        this.grades = grades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStdNumber() {
        return stdNumber;
    }

    public void setStdNumber(String stdNumber) {
        this.stdNumber = stdNumber;
    }

}

@Embeddable
class Grade {
    @NotBlank(message = "Course code is mandatory")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{3}$", message = "Invalid course code format (must be 2 uppercase letters followed by 3 digits)")
    private String code;

    @Min(value = 0, message = "Grade value cannot be negative")
    @Max(value = 100, message = "Grade value cannot exceed 100")
    private int value;

    public Grade() {
    }

    public Grade(String code, int value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}