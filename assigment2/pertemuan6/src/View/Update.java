package View;

import javax.swing.*;
import Controller.Controller;

public class Update extends JFrame {
    private int nim;
    JFrame window = new JFrame("Update Data Student");
    JLabel lNim = new JLabel("NIM");
    JTextField fNim = new JTextField();
    JLabel lName = new JLabel("NAME");
    JTextField fName = new JTextField();
    JLabel lAge = new JLabel("AGE");
    JTextField fAge = new JTextField();
    JButton btnUpd = new JButton("UPDATE");
    public Update(Controller connector, int nim) {
        this.nim = nim;
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
        window.add(btnUpd);
        lNim.setBounds(5, 35, 120, 20);
        lName.setBounds(5, 60, 120, 20);        
        lAge.setBounds(5, 85, 120, 20);
        fNim.setBounds(150, 35, 120, 20);
        fName.setBounds(150, 60, 120, 20);
        fAge.setBounds(150, 85, 120, 20);
        btnUpd.setBounds(300, 35, 90, 20);
        btnUpd.addActionListener(( e) -> {
            connector.updateData(nim, Integer.parseInt(fNim.getText()), fName.getText(), Integer.parseInt(fAge.getText()));
        });
    }

    
}
