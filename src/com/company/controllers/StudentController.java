package com.company.controllers;

//controls the Student Class Behaviour

import com.company.domain.Student;
import com.company.repository.StudentRepository;

public class StudentController {

    StudentRepository studentRepository = new StudentRepository();
    Student student;
    public StudentController(StudentRepository studentRepository) throws IllegalAccessException {
        this.studentRepository = studentRepository;
    }

    public void addStudent(int sId, String name, int age){
        student = new Student(sId, name, age);
        studentRepository.add(student);
    }

    public String showAllStudents(){
        return studentRepository.getAll();
    }

    public void deleteStudentById(int sId){
        studentRepository.removeById(sId);
    }

    public String readById(int sId){
        return studentRepository.getById(sId);
    }
    public void updateById(int sId, String name, int age){
        student = new Student(sId, name, age);
        studentRepository.update(student);
    }
    public void deleteTable(){
        studentRepository.deleteTable();

    }
}
