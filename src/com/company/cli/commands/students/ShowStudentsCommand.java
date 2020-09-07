package com.company.cli.commands.students;
import com.company.Command;

public class ShowStudentsCommand implements Command {

    @Override
    public String show() {
        return "Show a Student by ID";
    }

    @Override
    public void execute() {
        System.out.println("Execute From ShowStudentCommand");
    }
}
