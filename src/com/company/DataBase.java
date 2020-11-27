//package com.company;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DataBase {
//
//    private static String path = "C:\\Users\\DAN\\IdeaProjects\\pleto_oop1 - Copy\\db.sql";
//    public static String url = "jdbc:sqlite:" + path;
//
//    public static void createDB() throws Throwable{
//
//        try {
//            Connection connection = DriverManager.getConnection(url);
//            System.out.println("Successfully connected!");
//
//            Statement statement = connection.createStatement();
//            statement.execute("CREATE TABLE IF NOT EXISTS" +
//                    " students" +
//                    "( ID INTEGER," +
//                    " name TEXT," +
//                    " age INTEGER )");
//
//            statement.close();
//            connection.close();
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void addStudent(Student student){
//        try {
//            Connection connection = DriverManager.getConnection(url);
//
//            Statement statement = connection.createStatement();
//            int ID = student.ID;
//            String name = student.name;
//            int age = student.age;
//            statement.execute("INSERT INTO students " +
//                    "VALUES ('"
//                    + ID + "','" + name+ "','" + age + "');");
//
//            statement.close();
//            connection.close();
//
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//}
