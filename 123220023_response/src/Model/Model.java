package Model;

import Connector.Connector;
import Controller.Controller;
import java.sql.*;

public class Model extends Connector {
    private String name, path;
    private int total;
    private double writing, coding, interview, score;
    private String status; 
    private Statement statement;

    public Model(String name, String path, int total, double writing, double coding, double interview, double score, String status) {
        this.name = name;
        this.path = path;
        this.total = total;
        this.writing = writing;
        this.coding = coding;
        this.interview = interview;
        this.score = score;
        this.status = status;
    }

    public Model(Controller controller) {
    }

    // Method to calculate final score
    private double calculateFinalScore(double writing, double coding, double interview, String path) {
        // Calculate final score based on test scores and weight values
        // Use the provided weight values for Android Developers and Web Developers
        double finalScore;
        if (path.equals("Web Developer")) {
            finalScore = writing * 0.2 + coding * 0.5 + interview * 0.3;
        } else {
            finalScore = writing * 0.35 + coding * 0.4 + interview * 0.25;
        }
        return finalScore;
    }

    // Method to determine status based on final score
    private String determineStatus(double finalScore) {
        if (finalScore >= 85) {
            return "Accepted";
        } else {
            return "Not Accepted";
        }
    }

    public void insertData(String name, String path, double writing, double coding, double interview, double score) {
        try {
            // Calculate the final score
            double finalScore = calculateFinalScore(writing, coding, interview, path);

            // Determine status based on final score
            String determinedStatus = determineStatus(finalScore);

            // Prepare the SQL query
            String query = "INSERT INTO `kandidat`(`name`, `path`, `writing`, `coding`, `interview`, `score`, `status`) VALUES (?,?,?,?,?,?,?)";

            // Prepare the statement and set parameters
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, path);
            preparedStatement.setDouble(3, writing);
            preparedStatement.setDouble(4, coding);
            preparedStatement.setDouble(5, interview);
            preparedStatement.setDouble(6, score);
            preparedStatement.setString(7, determinedStatus);

            preparedStatement.executeUpdate();

            // Close the statement
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String[][] readData() {
        String data[][] = new String[100][8];
        try {
            int totalData = 0;
            String query = "SELECT * FROM kandidat";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data[totalData][0] = resultSet.getString("id");
                data[totalData][1] = resultSet.getString("name");
                data[totalData][2] = resultSet.getString("path");
                data[totalData][3] = resultSet.getString("writing");
                data[totalData][4] = resultSet.getString("coding");
                data[totalData][5] = resultSet.getString("interview");
                data[totalData][6] = resultSet.getString("score");
                data[totalData][7] = resultSet.getString("status");

                totalData++;
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("SQL Error" + e.getMessage());
        }
        return data;
    }

    public void updateData(int id, String name, String path, double writing, double coding, double interview, double score) {
        try {
            // Calculate the final score
            double finalScore = calculateFinalScore(writing, coding, interview, path);
    
            // Determine status based on final score
            String determinedStatus = determineStatus(finalScore);
    
            String query = "UPDATE `kandidat` SET `name`=?, `path`=?, `writing`=?, `coding`=?, `interview`=?, `score`=?, `status`=? WHERE `id`=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, path);
            preparedStatement.setDouble(3, writing);
            preparedStatement.setDouble(4, coding);
            preparedStatement.setDouble(5, interview);
            preparedStatement.setDouble(6, score);
            preparedStatement.setString(7, determinedStatus);
            preparedStatement.setInt(8, id); // Set ID parameter
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    

    public void deleteData(int id) {
        try {
            String query = "DELETE FROM `kandidat` WHERE `id`=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
