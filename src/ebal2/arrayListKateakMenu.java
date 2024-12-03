package ebal2;

import java.util.ArrayList;
import java.util.Scanner;

public class arrayListKateakMenu {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        Scanner teklatua = new Scanner(System.in);
        int aukera;
       do {
            // Menua erakutsi
            System.out.println("Menua:");
            System.out.println("1. String gehitu");
            System.out.println("2. String bilatu");
            System.out.println("3. String ezabatu");
            System.out.println("4. Array erakutsi");
            System.out.println("5. Irten");
            System.out.print("Aukeratu zenbaki bat: ");

            aukera = teklatua.nextInt();
            switch (aukera) {
                case 1: // String gehitu
                    System.out.print("Sartu gehitu nahi duzun stringa: ");
                    String gehituString = teklatua.nextLine();
                    array.add(gehituString);
                    System.out.println("Stringa gehitu da.");
                    break;

                case 2: // String bilatu
                    System.out.print("Sartu bilatu nahi duzun stringa: ");
                    String bilatuString = teklatua.nextLine();
                    if (array.contains(bilatuString)) {
                        System.out.println("Stringa aurkitu da: " + bilatuString);
                    } else {
                        System.out.println("Stringa ez da aurkitu.");
                    }
                    break;

                case 3: // String ezabatu
                    System.out.print("Sartu ezabatu nahi duzun stringa: ");
                    String ezabatuString = teklatua.nextLine();
                    if (array.remove(ezabatuString)) {
                        System.out.println("Stringa ezabatu da: " + ezabatuString);
                    } else {
                        System.out.println("Stringa ez da aurkitu, ezin da ezabatu.");
                    }
                    break;

                case 4: // Array erakutsi
                    if (array.isEmpty()) {
                        System.out.println("Arraya hutsik dago.");
                    } else {
                        System.out.println("Arrayaren elementuak:");
                        for (String str : array) {
                            System.out.println(str);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Progamatik irten");
                    break;

                default:
                    System.out.println("Aukera okerra, saiatu berriro.");
                    break;
            }
        }while (aukera > 0 || aukera < 6);
        teklatua.close(); // Scanner itxi
    }
}