package com.company.cli.commands.students;
import com.company.Command;
import com.company.cli.menus.MainMenu;
import com.company.controllers.StudentController;
import com.company.repository.StudentRepository;
import com.company.tools.readInt;


import java.util.Scanner;

public class AddStudentCommand implements Command  {

    StudentController studentController = new StudentController(new StudentRepository());

    public AddStudentCommand(StudentController studentController) throws IllegalAccessException {
        this.studentController = new StudentController(new StudentRepository());
    }

    @Override
    public String show() {
        return "Add Student";
    }

    @Override
    public void execute() throws Throwable {

        int sId = new readInt().input("ID: ");
        String name = readString("Name: ");
        int age = new readInt().input("Age: ");

        studentController.addStudent(sId, name, age);
    }

    private String readString(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        text= scanner.nextLine();
        return text;
    }



}
