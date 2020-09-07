package com.company.cli.commands;

import com.company.Command;

public class ExitCommand implements Command {

    @Override
    public String show() {
        return "Exit";
    }

    @Override
    public void execute() {

        System.exit(0);
    }
}
