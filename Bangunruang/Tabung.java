package Bangunruang;
import Bangundatar.Lingkaran;

public class Tabung extends Lingkaran implements bangunruang{
    double tinggiTabung;

    public Tabung (double r, double tinggiTabung) {
        super(r); 
        this.tinggiTabung = tinggiTabung;
        
    }
    public double volume (){
        return super.luas() * tinggiTabung;
    }
    public double luasPermukaan (){
        return 2 * super.luas() + super.keliling() * tinggiTabung;
    }
}
