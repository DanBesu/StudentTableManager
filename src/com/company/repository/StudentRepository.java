package com.company.repository;

// Controls the Database commands and give it to the controller

import com.company.domain.Student;

public class StudentRepository extends AbstractRepository{

    public StudentRepository() throws IllegalAccessException {
        super(Student.class, new Student());
    }

    public void add(Student student){
        super.add(Student.class, new Student(student.sId, student.name, student.age));
    }

    public void removeById(int sId){
        super.DeleteById(Student.class, sId);
    }

    public void update(Student student){
        super.UpdateById(Student.class, new Student(student.sId, student.name, student.age), student.sId);
    }

    public String getAll(){
        return super.getAll(Student.class);
    }

    public String getById(int sId){
        return super.ReadById(Student.class, sId);
    }

    public void deleteTable(){
        super.deleteTable(Student.class);
    }
}
