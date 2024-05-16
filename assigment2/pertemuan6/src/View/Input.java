package View;

import javax.swing.*;
import Controller.Controller;

public class Input extends JFrame {
    JFrame window = new JFrame("Student input");

    JLabel lNim = new JLabel("NIM");
    JTextField fNim = new JTextField();

    JLabel lName = new JLabel("NAME");
    JTextField fName = new JTextField();
    
    JLabel lAge = new JLabel("AGE");
    JTextField fAge = new JTextField();
    
    JButton btnAdd = new JButton("ADD");
   
    public Input(Controller connector) {
        window.setLayout(null);
        window.setSize(500, 200);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
        window.add(lNim);
        window.add(lName);
        window.add(lAge);
        window.add(fNim);
        window.add(fName);
        window.add(fAge);
        window.add(btnAdd);
       
        // Set bounds for labels
        lNim.setBounds(5, 35, 120, 20);
        lName.setBounds(5, 60, 120, 20);
        lAge.setBounds(5, 85, 120, 20);
        
        // Set bounds for text fields
        fNim.setBounds(150, 35, 120, 20);
        fName.setBounds(150, 60, 120, 20);
        fAge.setBounds(150, 85, 120, 20);
        
        // Set bounds for button
        btnAdd.setBounds(300, 35, 90, 20);
      
       
        btnAdd.addActionListener(( e) -> {
            connector.insertData(Integer.parseInt(fNim.getText()), fName.getText(), Integer.parseInt(fAge.getText()));
            window.dispose();
        });
    }
}
