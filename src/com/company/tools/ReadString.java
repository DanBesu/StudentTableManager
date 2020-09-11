package com.company.tools;

import java.util.Scanner;

public class ReadString {

    public String input(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        text= scanner.nextLine();
        return text;
    }
}
