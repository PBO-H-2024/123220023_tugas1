package View;

import Controller.Controller;

import javax.swing.*;

public class Update extends JFrame {
    JFrame window = new JFrame("Update");
    private int id;
    JLabel nameLabel = new JLabel("Name");
    JLabel pathLabel = new JLabel("Path");
    JLabel writingLabel = new JLabel("Writing");
    JLabel codingLabel = new JLabel("Coding");
    JLabel interviewLabel = new JLabel("Interview");
    JLabel scoreLabel = new JLabel("Score"); JLabel statusLabel = new JLabel("Status"); // Mengubah nama variabel untuk menghindari konflik
    JTextField nameField = new JTextField();
    JTextField pathField = new JTextField();
    JTextField writingField = new JTextField();
    JTextField codingField = new JTextField();
    JTextField interviewField = new JTextField();
    JTextField scoreField = new JTextField();
  

    public Update(Controller controller) {
        window.setSize(500, 600);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel.setBounds(50, 50, 100, 30);
        nameField.setBounds(150, 50, 200, 30);

        String[] pathOptions = {"Web Developer", "Mobile Developer"};
        JComboBox<String> pathDropdown = new JComboBox<>(pathOptions);

        pathLabel.setBounds(50, 100, 100, 30);
        pathDropdown.setBounds(150, 100, 200, 30);

        writingLabel.setBounds(50, 150, 100, 30);
        writingField.setBounds(150, 150, 200, 30);

        codingLabel.setBounds(50, 200, 100, 30);
        codingField.setBounds(150, 200, 200, 30);

        interviewLabel.setBounds(50, 250, 100, 30);
        interviewField.setBounds(150, 250, 200, 30);

        scoreLabel.setBounds(50, 300, 100, 30);
        scoreField.setBounds(150, 300, 200, 30);

       

        JButton update = new JButton("Update");
        update.setBounds(150, 400, 100, 30); /

        window.add(nameLabel);
        window.add(nameField);
        window.add(pathLabel);
        window.add(pathDropdown);
        window.add(writingLabel);
        window.add(writingField);
        window.add(codingLabel);
        window.add(codingField);
        window.add(interviewLabel);
        window.add(interviewField);
        window.add(scoreLabel);
        window.add(scoreField);
       
     
        window.add(update);

        update.addActionListener(e -> {
            controller.updateData(id, nameField.getText(), pathDropdown.getSelectedItem().toString(), id,
                    Double.parseDouble(writingField.getText()), Double.parseDouble(codingField.getText()),
                    Double.parseDouble(interviewField.getText()));
            JOptionPane.showMessageDialog(window, "Data has been updated successfully!");
            nameField.setText("");
            pathDropdown.setSelectedIndex(0);
            writingField.setText("");
            codingField.setText("");
            interviewField.setText("");
            scoreField.setText("");
            window.dispose();
            new Read(controller);
        });
    }
}
