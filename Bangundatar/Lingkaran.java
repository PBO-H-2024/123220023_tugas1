package Bangundatar;

public class Lingkaran {
    double  r;

    public Lingkaran(double r){
        this.r = r;
       
    }

    public double luas (){
        return Math.PI * r * r;
    }

    public double keliling () {
        return 2 * Math.PI * r;
    }
}
