package com.company.cli.menus;

import com.company.cli.menus.MenuInterface;
import com.company.Command;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu_v2 implements MenuInterface{

    //list
    List<Command> commandList = new ArrayList<>();

    @Override
    public String show() {
        return "Menu";
    }

    //private int index = -1;
    //private Command[] commands = new Command[100];
    /**@Override
    public void execute() throws Throwable {

        while (true) {
            try {
                for (int i = 0; i <= index; ++i)
                    System.out.println(i + ". " + commands[i].show());

                int cmd = read_int("Command: ");
                if (cmd <= index && cmd >= 0)
                    commands[cmd].execute();
                else System.out.println("Value out of range");
            }
            catch (RuntimeException e){
                break;
            }
        }
    }

    @Override
    public void appendCommand(Command command) {
        commands[++index] = command;
    }
    **/
    @Override
    public void execute() throws Throwable{

        while(true){
            try {
                int index = -1;
                for (Command c : commandList)
                    System.out.println(++index + ". " + c.show());

                int commandIndex = read_int("Command: ");
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
    public void appendCommand(Command command){
        commandList.add(command);
    }

    private int read_int(String text) throws Throwable {
        while(true){
            try {
                System.out.println(text);

                int input;
                Scanner insert = new Scanner(System.in);

                text = insert.nextLine();
                input = Integer.parseInt(text);
                return input;

            } catch (NumberFormatException e) {
                System.out.println("Please type an integer value.");
                this.execute();
            }
        }
    }
}
