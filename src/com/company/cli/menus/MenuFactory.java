/*
package com.company.cli.menus;

import com.company.cli.commands.BackCommand;
import com.company.cli.commands.ExitCommand;
import com.company.cli.commands.students.*;


public class MenuFactory extends Menu_v2 {

    public static Menu_v2 create(String menuType) {
        if (menuType.equals("MainMenu")) {
            return MenuFactory.createMainMenu();
        } else if (menuType.equals("StudentMenu")) {
            return MenuFactory.createStudentMenu();
        }
        return null;
    }

    private static Menu_v2 createMainMenu(){
        Menu_v2 menu = new Menu_v2();
        menu.appendCommand(new ExitCommand());
        menu.appendCommand(MenuFactory.createStudentMenu());

        return menu;
    }

    private static Menu_v2 createStudentMenu(){
        StudentMenu menu = new StudentMenu();
        menu.appendCommand(new BackCommand());
        menu.appendCommand(new AddStudentCommand());
        menu.appendCommand(new DeleteStudentCommand());
        menu.appendCommand(new UpdateStudentCommand());
        menu.appendCommand(new ShowStudentsCommand());
        menu.appendCommand(new ReadStudentCommand());

        return menu;
    }
}
*/