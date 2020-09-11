package com.company;

import com.company.cli.commands.students.*;
import com.company.cli.menus.MainMenu;
import com.company.cli.menus.StudentMenu;
import com.company.cli.commands.*;
import com.company.controllers.StudentController;
import com.company.domain.Student;
import com.company.repository.AbstractRepository;
import com.company.repository.StudentRepository;

public class Application{

    MainMenu mainMenu = new MainMenu();

    public Application() throws IllegalAccessException {

        StudentRepository studentRepository = new StudentRepository();
        StudentController studentController = new StudentController(studentRepository);

        StudentMenu studentMenu = new StudentMenu();
        studentMenu.appendCommand(new BackCommand());
        studentMenu.appendCommand(new AddStudentCommand(studentController));
        studentMenu.appendCommand(new DeleteStudentCommand(studentController));
        studentMenu.appendCommand(new UpdateStudentCommand(studentController));
        studentMenu.appendCommand(new ShowStudentsCommand(studentController));
        studentMenu.appendCommand(new ReadStudentCommand(studentController));
        studentMenu.appendCommand(new DeleteAllCommand(studentController));

        mainMenu.appendCommand(new ExitCommand());
        mainMenu.appendCommand(studentMenu);
    }

    public void start() throws Throwable {

        mainMenu.show();
        mainMenu.execute();
    }
}

