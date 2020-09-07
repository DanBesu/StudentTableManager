package com.company.cli.commands.students;

import com.company.Command;

public class UpdateStudentCommand implements Command {

    @Override
    public String show() {
        return "Update Student";
    }

    @Override
    public void execute() {
        System.out.println("Execute From UpdateStudentCommand");
    }
}
