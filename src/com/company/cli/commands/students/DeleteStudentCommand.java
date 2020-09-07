package com.company.cli.commands.students;
import com.company.Command;

public class DeleteStudentCommand implements Command {

    @Override
    public String show() {
        return "Delete a Student";
    }

    @Override
    public void execute() {
        System.out.println("Execute from DeleteStudentCommand");
    }
}
