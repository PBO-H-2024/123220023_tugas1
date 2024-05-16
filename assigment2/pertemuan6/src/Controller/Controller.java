package Controller;
import javax.swing.JOptionPane;
import Model.Model;

public class Controller {
    Model model;
    public Controller() {
        this.model = new Model(this);
    }
    
    public void insertData(int nim, String name, int age) {
        model.insertData(nim, name, age);
        JOptionPane.showMessageDialog(null, "Input Success");
    }
    
    public void updateData(int nim, int newNim, String name, int age) {
        model.updateData(nim, newNim, name, age);
        JOptionPane.showMessageDialog(null, "Update Success");
    }

    public String [][] readData() {
        return model.readData();
    }

    public void deleteData(int nim) {
        model.deleteData(nim);
        JOptionPane.showMessageDialog(null, "Delete Success");
    }
    
}
