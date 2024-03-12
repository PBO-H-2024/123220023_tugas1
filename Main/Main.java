package Main;

import Bangunruang.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome ambatron!");
            System.out.println("1. limas segitiga");
            System.out.println("2. tabung");
            System.out.println("3. exit");

            int pilih = input.nextInt();
            if (pilih == 1) {
                hitungLimas(input);
                backmenu(input);
            } else if (pilih == 2) {
               hitungTabung(input);
                backmenu(input);
            } else if (pilih == 3) {
                input.close();
                System.out.println("babaye");
                break;
            }

        }
    }

    public static void backmenu(Scanner scanner) {
        System.out.println("tekan enter untuk kembai ke menu...");
        scanner.nextLine();
        scanner.nextLine();
    }

    public static void hitungLimas(Scanner scanner) {
        System.out.println("input : ");
        System.out.println("input tinggi alasnya : ");
        double tinggiAlas = scanner.nextDouble();
        System.out.println("input alasnya : ");
        double alas = scanner.nextDouble();
        System.out.println("input tinggi limasnya : ");
        double tinggiLimas = scanner.nextDouble();

        System.out.println("hasil : ");
        Limas limas = new Limas(alas, tinggiAlas, tinggiLimas);
        System.out.println("luas segitiga : " + limas.luas());
        System.out.println("keliling segitiga : " + limas.keliling());
        System.out.println("volume limas : " + limas.volume());
        System.out.println("luas permukaan limas : " + limas.luasPermukaan());

    }

    public static void hitungTabung(Scanner scanner) {
         System.out.println("input  ");
         System.out.println("input jari jari : ");
         double jari = scanner.nextDouble();
         System.out.println("input tinggi : ");
         double tinggi = scanner.nextDouble();
         Tabung tabung = new Tabung(jari, tinggi);
         System.out.println("luas tabung : " + tabung.luas());
         System.out.println("keliling tabung : " + tabung.keliling());
         System.out.println("volume tabung : " + tabung.volume());
         System.out.println("luas permukaan tabung : " + tabung.luasPermukaan());
    }
}