package com.company.cli.commands.students;

import com.company.Command;
import com.company.controllers.StudentController;
import com.company.repository.StudentRepository;
import com.company.tools.ReadString;
import com.company.tools.readInt;

public class UpdateStudentCommand implements Command {

    StudentController studentController = new StudentController(new StudentRepository());

    public UpdateStudentCommand(StudentController studentController) throws IllegalAccessException {
        this.studentController = studentController;
    }

    @Override
    public String show() {
        return "Update Student";
    }

    @Override
    public void execute() throws Throwable {

        int sId = new readInt().input("ID: ");
        String name = new ReadString().input("New Name: ");
        int age = new readInt().input("New Age: ");

        studentController.updateById(sId, name, age);
    }
}
