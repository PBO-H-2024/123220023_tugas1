package Bangundatar;

public class Segitiga {
    double alas,tinggi;
    
    public Segitiga (double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }
    public double luas() {
        return alas * tinggi / 2;
    }
    public double keliling() {
        double Pytagoras = Math.sqrt((1/2*(alas) * 1/2*(alas) + (tinggi * tinggi)));
        return (2 * Pytagoras) + alas;
       
    }
}
