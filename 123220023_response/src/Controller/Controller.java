package Controller;
import Model.Model;

import javax.swing.JOptionPane;;


public class Controller {
    Model model;
    


    public Controller () {
        this.model = new Model(this);
    }
   public void insertData(String name, String path, double writing, double coding, double interview, double score) {
       model.insertData(name, path, writing, coding, interview, score);
       JOptionPane.showMessageDialog(null, "Data has been inserted successfully");
   }

   public String[][] readData() {
       return model.readData();
   }
public void deleteData (int id) {
    model.deleteData(id);
    JOptionPane.showMessageDialog(null, "Data has been deleted successfully");
}

public void updateData(int id, String name, String path, double writing, double coding, double interview, double score) {
    model.updateData(id, name, path, writing, coding, interview, score);
    JOptionPane.showMessageDialog(null, "Data has been updated successfully");
}




}