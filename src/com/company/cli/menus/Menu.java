package com.company.cli.menus;

import com.company.Command;

public interface Menu extends Command {

    public default void appendCommand(Command command){

    }

}
