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
        return alas + tinggi + Math.sqrt((alas * alas) + (tinggi * tinggi));
    }
}
