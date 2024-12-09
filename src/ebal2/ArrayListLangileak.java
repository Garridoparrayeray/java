package ebal2;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListLangileak {
    public static void main(String[] args) {
        Scanner teklatua = new Scanner(System.in);
        ArrayList<Langilea> langileak = new ArrayList<>();

        System.out.println("Langileen datuak sartu. 'amaiera' NAN eremuan idatzi bukatzeko.");
        while (true) {
            System.out.println("Langile berri bat gehitzen...");
            System.out.print("Sartu NAN (edo 'amaiera' bukatzeko): ");
            String nan = teklatua.nextLine().trim();

            if (nan.equalsIgnoreCase("amaiera")) {
                System.out.println("Datuen sarrera amaituta.");
                break;
            }

            System.out.print("Sartu izena: ");
            String izena = teklatua.nextLine().trim();

            System.out.print("Sartu abizena: ");
            String abizena = teklatua.nextLine().trim();

            System.out.print("Sartu saila: ");
            String saila = teklatua.nextLine().trim();

            System.out.print("Sartu lanpostua: ");
            String lanpostua = teklatua.nextLine().trim();

            double soldata = 0.0;
            boolean soldataEgokia = false;
            while (!soldataEgokia) {
                System.out.print("Sartu soldata: ");
                try {
                    soldata = Double.parseDouble(teklatua.nextLine().trim());
                    if (soldata < 0) {
                        System.out.println("Soldata ezin da negatibo izan. Saiatu berriro.");
                    } else {
                        soldataEgokia = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Soldata ez da zenbaki bat. Saiatu berriro.");
                }
            }

            Langilea langilea = new Langilea(nan, izena, abizena, saila, lanpostua, soldata);
            langileak.add(langilea);

            System.out.println("Langilea gehituta: " + langilea);
        }


        System.out.println("Sartutako langile guztiak:");
        for (Langilea langilea : langileak) {
            System.out.println(langilea);
        }

        teklatua.close();
    }
}
