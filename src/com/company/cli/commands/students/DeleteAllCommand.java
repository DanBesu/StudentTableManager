package com.company.cli.commands.students;

import com.company.Command;
import com.company.controllers.StudentController;
import com.company.repository.StudentRepository;

public class DeleteAllCommand implements Command {

    StudentController studentController = new StudentController(new StudentRepository());

    public DeleteAllCommand(StudentController studentController) throws IllegalAccessException {
        this.studentController = new StudentController(new StudentRepository());
    }

    @Override
    public String show() {
        return "Delete all students";
    }

    @Override
    public void execute() throws Throwable {
        studentController.deleteTable();
        new StudentRepository();
    }
}
