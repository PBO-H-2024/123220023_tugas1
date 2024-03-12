package Bangunruang;
import Bangundatar.Segitiga;

public class Limas extends Segitiga implements bangunruang  {
    double tinggiLimas;
    public Limas (double alas, double tinggi, double tinggiLimas) {
        super(alas, tinggi);
        this.tinggiLimas = tinggiLimas;
    }
    public double volume () {
        return (1.0/3) * super.luas() * tinggiLimas;
    }
    public double luasPermukaan () {
        return 2 * super.luas() + super.keliling() * tinggiLimas;
    }
}


