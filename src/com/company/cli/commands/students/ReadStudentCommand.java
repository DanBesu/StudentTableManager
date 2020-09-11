package com.company.cli.commands.students;
import com.company.Command;
import com.company.controllers.StudentController;
import com.company.repository.StudentRepository;
import com.company.tools.readInt;

public class ReadStudentCommand implements Command {

    StudentController studentController = new StudentController(new StudentRepository());

    public ReadStudentCommand(StudentController studentController) throws IllegalAccessException {
        this.studentController = new StudentController(new StudentRepository());
    }

    @Override
    public String show() {
        return "Read a student";
    }

    @Override
    public void execute() throws Throwable {
        int sId = new readInt().input("Insert ID: ");
        String rowValues = studentController.readById(sId);
        System.out.println(rowValues);
    }
}
