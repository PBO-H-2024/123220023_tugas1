package Connector;

import java.sql.*;

public class Connector {
    String DBurl = "jdbc:mysql://localhost/student_db";
    String DBusername = "root";
    String DBpassword = "";

    protected Connection conn;
    Statement statement;

    public Connector() {
       getConnection();
    }
    public void getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Connection Success");
        } catch (Exception ex) {
            System.out.println("Connection Failed " + ex.getMessage());
        }
    }

   
    
}
