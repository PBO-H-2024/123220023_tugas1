package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Read extends JFrame {
    JFrame window = new JFrame("Read");
    public int id, score;
    String[][] data = new String[100][8];
    JTable table;
    DefaultTableModel model;
    Object[] columnName = {"ID", "Name", "Path", "Writing", "Coding", "Interview", "Score", "Status"};
    JScrollPane scrollPane;
    JButton Add = new JButton("Add");
    JButton Refresh = new JButton("Refresh");
    JButton Clear = new JButton("Clear");

    public Read(Controller controller) {
        window.setSize(1000, 1000);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        model = new DefaultTableModel(columnName, 0);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 500, 500);
        window.add(scrollPane);

        Add.setBounds(0, 500, 100, 30);
        Refresh.setBounds(100, 500, 100, 30);
        Clear.setBounds(200, 500, 100, 30);
        window.add(Add);
        window.add(Refresh);
        window.add(Clear);

        loadData(controller);

        Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Insert(controller);
            }
        });

        Refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData(controller);
            }
        });

        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                String name = table.getValueAt(selectedRow, 1).toString();

                int input = JOptionPane.showConfirmDialog(null,
                        "Do you want to delete " + name + " with ID: " + id + "?",
                        "Option...",
                        JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    controller.deleteData(id);
                    loadData(controller);
                } else {
                    input = JOptionPane.showConfirmDialog(null,
                            "Do you want to update " + name + " with ID: " + id + "?",
                            "Option...",
                            JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        new Update(controller);
                        loadData(controller);
                    }
                }
            }
        });
    }

    private void loadData(Controller controller) {
        model.setRowCount(0); // Clear the existing data
        data = controller.readData();
        for (String[] row : data) {
            if (row[0] != null) {
                model.addRow(row);
            }
        }
    }
}
