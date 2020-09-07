package com.company.cli.commands.students;
import com.company.Command;

public class ReadStudentCommand implements Command {

    @Override
    public String show() {
        return "Read a student";
    }

    @Override
    public void execute() {
        System.out.println("Execute from  ReadStudentCommand");
    }
}
