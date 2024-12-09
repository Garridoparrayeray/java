package ebal2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class arrayListKateakMenu {
    public static void main(String[] args) {
        Scanner teklatua = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<String>();
        int aukera = 0;
        String str;

        do {
            System.out.println("-------MENU------" + "\n" +
                "1. Gehitu array-a" + "\n" +
                "2. Bilatu array-a" + "\n" +
                "3. Ezabatu array-a" + "\n" +
                "4. Array erakutsi" + "\n" +
                "5. Irten");
            System.out.print("Sartu zenbaki egoki bat: ");
            try {
                aukera = teklatua.nextInt();
                teklatua.nextLine(); // Consume the newline character
            } catch (InputMismatchException e) {
                System.out.println("Sartu zenbaki egoki bat");
                teklatua.nextLine(); // Clear invalid input
                continue; // Skip the rest of the loop iteration
            }

            switch (aukera) {
                case 1:
                    System.out.println("Zer gehitu nahi duzu?");  
                    str = teklatua.nextLine();
                    lista.add(str);
                    break;
                case 2:
                    System.out.println("Zer arakatu nahi duzu?");
                    str = teklatua.nextLine();
                    if (lista.contains(str)) {
                        System.out.println("Elementua aurkitu da: " + str);
                    } else {
                        System.out.println("Ez dago: " + str);
                    }
                    break;
                case 3:
                    System.out.println("Zer ezabatu nahi duzu?");
                    str = teklatua.nextLine();
                    if (lista.remove(str)) {
                        System.out.println("Array " + str + " ezabatu da");
                    } else {
                        System.out.println("Ez dago: " + str);
                    }
                    break;
                case 4:
                    if (lista.isEmpty()) {
                        System.out.println("Ez daude elementurik");
                    } else {
                        for (String i : lista) {
                            System.out.println(i);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Irten egiten...");
                    break;
                default:
                    System.out.println("Sartu zenbaki egoki bat");
                    break;
            }
        } while (aukera < 1 || aukera > 5);

        teklatua.close(); // Close the scanner
    }
}