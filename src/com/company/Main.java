package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Throwable {

        Application app = new Application();
        app.start();

    }

    /*public static void main(String[] args) {
        String path = "C:\\Users\\DAN\\IdeaProjects\\pleto_oop1 - Copy\\db.sql";
        String url = "jdbc:sqlite:" + path;

        try {
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Successfully connected!");

            Statement statement = connection.createStatement();
            statement.execute("INSTRUCTIONS");

            statement.close();
            connection.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
}