package com.company.cli.commands.students;
import com.company.Command;
import com.company.controllers.StudentController;
import com.company.repository.StudentRepository;


public class ShowStudentsCommand implements Command {

    StudentController studentController = new StudentController(new StudentRepository());

    public ShowStudentsCommand(StudentController studentController) throws IllegalAccessException {
        this.studentController = studentController;
    }

    @Override
    public String show() {
        return "Show all Students";
    }

    @Override
    public void execute() {
        String AllStudents = studentController.showAllStudents();
        System.out.println(AllStudents);
    }
}
