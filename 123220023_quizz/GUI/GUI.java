package GUI;

import javax.swing.*;

import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

    private JTextField nameField, nimField, writingField, codingField, interviewField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public GUI() {
        setTitle("PT OOP SUKAMAJU");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel nimLabel = new JLabel("NIM:");
        nimField = new JTextField();
        JLabel writingLabel = new JLabel("Writing Exam:");
        writingField = new JTextField();
        JLabel codingLabel = new JLabel("Coding Test:");
        codingField = new JTextField();
        JLabel interviewLabel = new JLabel("Interview Test:");
        interviewField = new JTextField();
        JLabel blankLabel = new JLabel("");
        JLabel resultTitleLabel = new JLabel("Result:");
        resultLabel = new JLabel("");

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        add(nameLabel);
        add(nameField);
        add(nimLabel);
        add(nimField);
        add(writingLabel);
        add(writingField);
        add(codingLabel);
        add(codingField);
        add(interviewLabel);
        add(interviewField);
        add(blankLabel);
        add(calculateButton);
        add(resultTitleLabel);
        add(resultLabel);

        nameLabel.setBounds(10, 10, 120, 20);
        nameField.setBounds(10, 30, 120, 20);
        nimLabel.setBounds(10, 50, 120, 20);
        nimField.setBounds(10, 70, 120, 20);
        writingLabel.setBounds(10, 90, 120, 20);
        writingField.setBounds(10, 110, 120, 20);
        codingLabel.setBounds(10, 130, 120, 20);
        codingField.setBounds(10, 150, 120, 20);
        interviewLabel.setBounds(10, 170, 120, 20);
        interviewField.setBounds(10, 190, 120, 20);
        blankLabel.setBounds(10, 210, 120, 20);
        calculateButton.setBounds(10, 230, 120, 20);
        resultTitleLabel.setBounds(10, 250, 120, 20);
        resultLabel.setBounds(10, 270, 120, 20);

    }

    @Override
    public void actionPerformed(ActionEvent exception) {
        try {

            String name = nameField.getText();
            String nim = nimField.getText();
            double writingScore = Double.parseDouble(writingField.getText());
            double codingScore = Double.parseDouble(codingField.getText());
            double interviewScore = Double.parseDouble(interviewField.getText());

            double androidScore = (writingScore * 0.2 + codingScore * 0.5 + interviewScore * 0.3);
            double webScore = (writingScore * 0.4 + codingScore * 0.35 + interviewScore * 0.25);

            String hasil;
            if (androidScore >= 85) {
                hasil = "ACCEPTED as a Android Developer";
            } else if (webScore >= 85) {
                hasil = "ACCEPTED as a Web Developer";
            } else {
                hasil = "NOT ACCEPTED";
            }

            resultLabel.setText(hasil);
            System.out.println("name : " + name);
            System.out.println("nim : " + nim);
            System.out.println("writing score : " + writingScore);
            System.out.println("coding score : " + codingScore);
            System.out.println("interview score : " + interviewScore);
            System.out.println("android score : " + androidScore);
            System.out.println("web score : " + webScore);
            System.out.println("result : " + hasil);
        } catch (NumberFormatException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

}
