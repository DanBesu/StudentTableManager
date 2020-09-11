package com.company.cli.menus;

import com.company.Command;
import com.company.tools.readInt;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Menu {

    List<Command> commandList = new ArrayList<>();

    @Override
    public String show() {
        return "Main Menu";
    }

    @Override
    public void execute() throws Throwable {

        while(true){
            try {
                int index = -1;
                for (Command c : commandList)
                    System.out.println(++index + ". " + c.show());

                int commandIndex = new readInt().input("Command: ");
                commandList.get(commandIndex).execute();

            } catch (IndexOutOfBoundsException e) {
                int listSize = commandList.size() - 1;
                System.out.println("Please type a number in range [0," + listSize + ']');
            }catch (RuntimeException e){
                break;
            }
        }
    }

    @Override
    public void appendCommand(Command command) {
        commandList.add(command);
    }
}
