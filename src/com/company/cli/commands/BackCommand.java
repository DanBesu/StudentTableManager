package com.company.cli.commands;

import com.company.Command;

public class BackCommand implements Command {

    @Override
    public String show() {
        return "Go Back";
    }

    @Override
    public void execute(){
        throw new java.lang.RuntimeException();
    }
}
