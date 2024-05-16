package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

import javax.swing.table.DefaultTableModel;
import Controller.Controller;


public class Read {

    public int nim, age;
    public String name;
    int totalData;
    String data[][] = new String[100][3];

    JFrame window = new JFrame("read data student");
    JTable tabel;
    DefaultTableModel model;
    JScrollPane scrollPane;
    Object columnName[] = { "NIM", "Name", "Age" };

    JButton btnAdd = new JButton("ADD");
    JButton btnRefresh = new JButton("REFRESH");

    public Read(Controller connector) {
        model = new DefaultTableModel(columnName, 0);
        tabel = new JTable(model);
        scrollPane = new JScrollPane(tabel);
        window.setLayout(null);
        window.setSize(550, 600);
        // window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        window.add(scrollPane);
        window.add(btnAdd);
        window.add(btnRefresh);
        scrollPane.setBounds(20, 35, 500, 300);
        btnAdd.setBounds(20, 350, 90, 20);
        btnRefresh.setBounds(120, 350, 120, 20);

        data = connector.readData();

        tabel.setModel((new JTable(data, columnName)).getModel());

        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                super.mouseClicked(e);

                int row = tabel.getSelectedRow();
                int nim = Integer.parseInt(tabel.getValueAt(row, 0).toString());
                String name = tabel.getValueAt(row, 1).toString();

                int input = JOptionPane.showConfirmDialog(null,
                        "do you want to delete " + name +  nim + "?",
                        "Option...",
                        JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    connector.deleteData(nim);
                } else {
                    input = JOptionPane.showConfirmDialog(null,
                            "Do you want to update " + name + nim + "?",
                            "Option...",
                            JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                       new Update(connector, nim);
                    }

                }
            }
        });

        btnAdd.addActionListener(e -> {
            new Input(connector);
        });

        btnRefresh.addActionListener(e -> {
            new Read(connector);
            window.dispose();
        });
        


    }

    
}
