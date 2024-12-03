package ebal2;

import java.util.ArrayList;
import java.util.Scanner;

public class IkasleMain {
    private static ArrayList<Ikaslea> ikasleak = new ArrayList<>();

    public static void main(String[] args) {
        Scanner teklatua = new Scanner(System.in);
        boolean irten;

        do {
            System.out.println("Menua:");
            System.out.println("1. Ikasleak sartu");
            System.out.println("2. Ikasleak kontsultatu NAN-ez");
            System.out.println("3. Ikasleak ezabatu");
            System.out.println("4. Taldeen zerrendak atera");
            System.out.println("5. Irten");
            System.out.print("Aukeratu aukera: ");

            int aukera = teklatua.nextInt();
            teklatua.nextLine();
            irten = false;//do amaitzeko true jartzen da

            switch (aukera) {
                case 1:
                    System.out.print("Sartu NAN: ");
                    String nan = teklatua.nextLine();
                    System.out.print("Sartu izena: ");
                    String izena = teklatua.nextLine();
                    System.out.print("Sartu abizena: ");
                    String abizena = teklatua.nextLine();
                    System.out.print("Sartu maila: ");
                    String maila = teklatua.nextLine();
                    System.out.print("Sartu zikloa: ");
                    String zikloa = teklatua.nextLine();
                    
                    try {
                        Ikaslea ikaslea = new Ikaslea(nan, izena, abizena, maila, zikloa);
                        ikasleak.add(ikaslea);
                        System.out.println("Ikaslea ondo gehitu da.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Errorea: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Sartu NAN kontsultatzeko: ");
                    String kontsultaNan = teklatua.nextLine();
                    Ikaslea ikasleaFound = null;
                    for (Ikaslea ikasleaItem : ikasleak) {
                        if (ikasleaItem.getNan().equals(kontsultaNan)) {
                            ikasleaFound = ikasleaItem;
                            break;
                        }
                    }
                    if (ikasleaFound != null) {
                        System.out.println(ikasleaFound);
                    } else {
                        System.out.println("Ikaslea ez da aurkitu NAN honekin: " + kontsultaNan);
                    }
                    break;

                case 3:
                    System.out.print("Sartu NAN ezabatzeko: ");
                    String ezabatuNan = teklatua.nextLine();
                    boolean aurkituta = false;
                    for (Ikaslea ikasleaItem : ikasleak) {
                        if (ikasleaItem.getNan().equals(ezabatuNan)) {
                            ikasleak.remove(ikasleaItem);
                            System.out.println("Ikaslea ondo ezabatu da.");
                            aurkituta = true;
                            break;
                        }
                    }
                    if (!aurkituta) {
                        System.out.println("Ikaslea ez da aurkitu NAN honekin: " + ezabatuNan);
                    }
                    break;

                case 4:
                    System.out.println("Taldeen zerrenda:");
                    for (Ikaslea ikasleaItem : ikasleak) {
                        System.out.println(ikasleaItem);
                    }
                    break;

                case 5:
                    irten = true;
                    System.out.println("Programatik irten da.");
                    break;

                default:
                    System.out.println("Aukera baliogabea. Mesedez, saiatu berriro.");
                    break;
            }
        } while (!irten);
        
        teklatua.close();
    }
}