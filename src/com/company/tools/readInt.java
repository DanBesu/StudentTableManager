package com.company.tools;

import com.company.cli.menus.MainMenu;
import com.company.cli.menus.Menu;

import java.util.Scanner;

public class readInt {

    public int input(String text) throws Throwable{
        while(true){
            try {
                System.out.println(text);

                int input;
                Scanner insert = new Scanner(System.in);

                String text_to_read = insert.nextLine();

                input = Integer.parseInt(text_to_read);
                return input;

            } catch (NumberFormatException e) {
                System.out.println("Please type an integer value.");
            }
        }
    }
}
