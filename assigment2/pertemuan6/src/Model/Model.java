package Model;

import Connector.Connector;
import Controller.Controller;

import java.sql.*;




public class Model extends Connector{
    private int nim, age;
    private String name;
    private  Statement statement;

    public Model(int nim, String name, int age) {
        this.nim = nim;
        this.name = name;
        this.age = age;
    }

    public Model(Controller controller) {
        //TODO Auto-generated constructor stub
    }

    public String[][] readData() {
        String data[][] = new String[10][3]; 
        try {
            int totalData = 0;
            String query = "SELECT * FROM student";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                // Memuat data kecuali kolom ID
                data[totalData][0] = resultSet.getString("nim");
                data[totalData][1] = resultSet.getString("name");
                data[totalData][2] = resultSet.getString("age");
                totalData++;
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("SQL Error" + e.getMessage());
        }
        return data;



    }

    
    public void insertData(int nim, String name, int age) {
        try {
            String query = "INSERT INTO `student`(`nim`,`name`,`age`) VALUES ('" + nim + "','" + name + "','" + age
                    + "')";

            statement = conn.createStatement();
            statement.executeUpdate(query);

            System.out.println("Input Success");
        } catch (Exception ex) {
            System.out.println("Input Failed " + ex.getMessage());
        }
    }

    public void updateData(int nim, int newNim, String name, int age) {
        try {
            String query = "UPDATE `student` SET nim= '" + newNim + "',"
                    + " name= '" + name + "',"
                    + " age= '" + age + "' WHERE nim = '" + nim + "'";

            statement = conn.createStatement();
            statement.executeUpdate(query);

            System.out.println("Update Success");
        } catch (Exception ex) {
            System.out.println("Update Failed : " + ex.getMessage());
        }
    }

    public void deleteData(int nim) {
        try {
            String query = "DELETE FROM `student` WHERE nim='" + nim + "'";
    
            statement = conn.createStatement();
            statement.executeUpdate(query);
    
            System.out.println("Delete Success");
        } catch (Exception ex) {
            System.out.println("Delete Failed : " + ex.getMessage());
        }
    }





}