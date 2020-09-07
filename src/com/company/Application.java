package com.company;

import com.company.cli.menus.MenuFactory;
import com.company.cli.menus.Menu_v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Application{
    //public Menu_v2 menu = new Menu_v2();

    public Menu_v2 menu = MenuFactory.create("MainMenu");

    public void start() throws Throwable {

        DataBase.createDB();
        menu.show();
        menu.execute();
    }
}
