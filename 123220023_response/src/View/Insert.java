package View;
import Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Insert extends JFrame {
    JFrame window = new JFrame("Insert");
    JLabel nameLabel = new JLabel("Name");
    JTextField nameTextField = new JTextField();
    
    JLabel pathLabel = new JLabel("Path");
    String[] pathOptions = {"Web Developer", "Mobile Developer"};
    JComboBox<String> pathDropdown = new JComboBox<>(pathOptions);
    
    JLabel writingLabel = new JLabel("Writing");
    JTextField writingTextField = new JTextField();
    
    JLabel codingLabel = new JLabel("Coding");
    JTextField codingTextField = new JTextField();
    
    JLabel interviewLabel = new JLabel("Interview");
    JTextField interviewTextField = new JTextField();
    
    JLabel scoreLabel = new JLabel("Score");
    JTextField scoreTextField = new JTextField();
    
    JButton addButton = new JButton("Add");

    public Insert(Controller controller) {
        window.setSize(500, 600);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set bounds for labels and text fields
        nameLabel.setBounds(50, 50, 100, 30);
        nameTextField.setBounds(150, 50, 200, 30);
        
        pathLabel.setBounds(50, 100, 100, 30);
        pathDropdown.setBounds(150, 100, 200, 30);
        
       
        
        writingLabel.setBounds(50, 200, 100, 30);
        writingTextField.setBounds(150, 200, 200, 30);
        
        codingLabel.setBounds(50, 250, 100, 30);
        codingTextField.setBounds(150, 250, 200, 30);
        
        interviewLabel.setBounds(50, 300, 100, 30);
        interviewTextField.setBounds(150, 300, 200, 30);
        
        scoreLabel.setBounds(50, 350, 100, 30);
        scoreTextField.setBounds(150, 350, 200, 30);
        
        addButton.setBounds(50, 400, 100, 30);

        // Add components to the window
        window.add(nameLabel);
        window.add(nameTextField);
        window.add(pathLabel);
        window.add(pathDropdown);
        window.add(writingLabel);
        window.add(writingTextField);
        window.add(codingLabel);
        window.add(codingTextField);
        window.add(interviewLabel);
        window.add(interviewTextField);
        window.add(scoreLabel);
        window.add(scoreTextField);
        window.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values
                String name = nameTextField.getText();
                String path = (String) pathDropdown.getSelectedItem();
               
                double writing = Double.parseDouble(writingTextField.getText());
                double coding = Double.parseDouble(codingTextField.getText());
                double interview = Double.parseDouble(interviewTextField.getText());
                double score = calculateFinalScore(writing, coding, interview, path);
                String status = determineStatus(score);

                // Insert data using the controller
                controller.insertData(name, path, writing, coding, interview, score);

                // Display success message
                JOptionPane.showMessageDialog(window, "Data has been added successfully!");

                // Clear input fields
                nameTextField.setText("");
                writingTextField.setText("");
                codingTextField.setText("");
                interviewTextField.setText("");
                scoreTextField.setText("");
                window.dispose();
                new Read(controller);
            }
        });
    }

    private String determineStatus(double score) {
        return score >= 85 ? "Accepted" : "Not Accepted";
    }

    private double calculateFinalScore(double writing, double coding, double interview, String path) {
        double finalScore;
        if (path.equals("Web Developer")) {
            finalScore = writing * 0.2 + coding * 0.5 + interview * 0.3;
        } else {
            finalScore = writing * 0.35 + coding * 0.4 + interview * 0.25;
        }
        return finalScore;
    }
}
