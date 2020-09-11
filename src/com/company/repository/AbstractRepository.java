package com.company.repository;

import com.company.domain.Student;
import java.lang.reflect.Field;
import java.lang.reflect.*;
import java.sql.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class AbstractRepository {

    Class reflectClass;
    Object classObject;
    String path = "C:\\Users\\DAN\\IdeaProjects\\pleto_oop1 - Copy\\" + new Properties().dbName;
    String url = "jdbc:sqlite:" + path;

    public AbstractRepository(Class reflectClass, Object classObject) throws IllegalAccessException {

        this.reflectClass = reflectClass;
        this.classObject = classObject;

        String Attributes = MapToSqlAttributes(reflectClass);
        //System.out.println(Attributes);
        String className = reflectClass.getSimpleName().toString();
        //System.out.println(className);

        createTable(className, Attributes);
    }

    private void createTable(String className, String Attributes){

        try {
            Connection connection = DriverManager.getConnection(url);

            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + className + " (" + Attributes + "); ");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void add(Class cls, Object classObject){

        try {
            Connection connection = DriverManager.getConnection(url);

            String values = getFieldValues(cls, classObject);
            Statement statement = connection.createStatement();

            statement.execute( "INSERT INTO " + cls.getSimpleName().toString() + " VALUES (" + values + ");");
            statement.close();
            connection.close();

        } catch (SQLException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getAll(Class cls){
        Field[] fields = cls.getFields();
        String values = "";
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM " + cls.getSimpleName().toString() );
            while(rs.next()){
                for(Field field : fields){
                    values += rs.getString(field.getName().toString()) + " ";
                }
                values += '\n';
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return values;
    }

    public void DeleteById(Class cls, int Id){

        try{
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            String IdColumn = findIdCollumName(cls);
            statement.execute("DELETE FROM " + cls.getSimpleName() + " WHERE " + IdColumn + "=" + Id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String ReadById(Class cls, int Id){

        String IdCollumn = findIdCollumName(cls);
        Field[] fields = cls.getFields();

        try{
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            String rowValues = "";
            ResultSet rs = statement.executeQuery("SELECT * FROM " + cls.getSimpleName().toString() + " WHERE " + IdCollumn +  "=" + Id);

            while(rs.next()){
                for(Field field : fields){
                    rowValues += rs.getString(field.getName().toString()) + " ";
                }
            }
            return rowValues;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "NOT FOUND";
    }

    public void UpdateById(Class cls, Object obj, int Id){
        Field[] fields = cls.getFields();
        String idCollumn = findIdCollumName(cls);

        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            for(Field field:fields){
                statement.execute("UPDATE " + cls.getSimpleName() + " SET " + field.getName().toString() + "= '" + field.get(obj).toString() + "'" + " WHERE " + idCollumn + "=" + Id);
            }

            statement.close();
            connection.close();

        } catch (SQLException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTable(Class cls){
        try {
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            statement.execute("DROP TABLE " + cls.getSimpleName().toString());

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private String MapToSqlAttributes(Class cls){
        Dictionary toSql = new Hashtable();
        toSql.put("int", "INTEGER");
        toSql.put("java.lang.String", "TEXT");

        Field[] fields = cls.getFields();
        String Attributes = "";

        for(Field field: fields){
            Attributes += field.getName().toString() + ' ' + toSql.get(field.getType().getName().toString()) + ", ";
        }

        Attributes = Attributes.substring(0, Attributes.length() - 2);

        return Attributes;
    }

    private String getFieldValues(Class cls, Object obj) throws IllegalAccessException {

        Field[] fields = cls.getFields();
        String AllValues = "";
        for(Field field:fields){
            AllValues += "'" + field.get(obj) + "', ";
        }
        AllValues = AllValues.substring(0, AllValues.lastIndexOf(","));
        //System.out.println(AllValues);
        return AllValues;
    }
    private String findIdCollumName(Class cls){
        Field[] fields = cls.getFields();

        try{
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();

            for(Field field: fields){
                if(field.getName().toString().contains("Id"))
                    return field.getName().toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "NO ID HERE WTF";
    }
}
