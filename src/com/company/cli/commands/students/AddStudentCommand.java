package com.company.cli.commands.students;
import com.company.Command;
import com.company.DataBase;
import com.company.Student;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddStudentCommand implements Command  {

    int ID;
    String name;
    int age;


    @Override
    public String show() {
        return "Add Student";
    }

    @Override
    public void execute() throws Throwable {

        Scanner insert = new Scanner(System.in);
        String input;

        ID = read_int("ID: ");
        System.out.println("Name: ");
        name = insert.nextLine();
        age = read_int("Age: ");

        DataBase.addStudent(new Student(ID, name, age));
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
