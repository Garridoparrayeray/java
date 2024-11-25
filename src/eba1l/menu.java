﻿//MODU EGOKIENA HAU DA.
/*
package eba1l;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        double num_1;
        double num_2;
        double emaitza;
        int operazioa;

        emaitza = 0;
        Scanner teklatua = new Scanner(System.in);
        while (true) {
            System.out.println("Sartu zer operazio egin nahi duzun: \n"
                    + "1 - Gehitu \n"
                    + "2 - Kenketa \n"
                    + "3 - Biderketa \n"
                    + "4 - zatiketa \n"
                    + "5 - irten");
            while (true) {
                try {
                    operazioa = teklatua.nextInt();
                    if (operazioa < 1 || operazioa > 5) {
                        System.out.println("Sartu menu zenbaki egokia.\n"
                        		+ "1 - Gehitu \n"
                                + "2 - Kenketa \n"
                                + "3 - Biderketa \n"
                                + "4 - zatiketa \n"
                                + "5 - irten");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Sartu zenbaki bat.");
                    teklatua.next(); // Clear invalid input
                }
            }
            if (operazioa == 5) {
                break;
            }
            System.out.println("Sartu lehenengo zenbakia: ");
            num_1 = teklatua.nextDouble();
            System.out.println("Sartu bigarren zenbakia: ");
            while (true) {
                try {
                    num_2 = teklatua.nextDouble();
                    if (operazioa == 4 && num_2 == 0) {
                        System.out.println("Bigarren zenbakia ezin da izan 0!");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Sartu zenbaki bat.");
                    teklatua.next(); // Limpia el input invalido
                }
            }
            switch (operazioa) {
                case 1:
                    emaitza = num_1 + num_2;
                    break;
                case 2:
                    emaitza = num_1 - num_2;
                    break;
                case 3:
                    emaitza = num_1 * num_2;
                    break;
                case 4:
                    emaitza = num_1 / num_2;
                    break;
            }
            System.out.println("Emaitza: " + emaitza + " da");
        }
        teklatua.close();
    }
}
*/
//BIGARREN MODUA, ERRAZANA ETA IKASITAKOAREKIN
package eba1l;
import java.util.Scanner;

public class menu {
	public static void main(String[]args) {
		double num_1;
		double num_2;
		double emaitza;
		int operazioa;
		//Bariablea hasi
		emaitza = 0;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Sartu zer operazio egin nahi duzun: \n"
				+ "1 - Gehitu \n"
				+ "2 - Kenketa \n"
				+ "3 - Biderketa \n"
				+ "4 - zatiketa \n"
				+ "5 - irten");
			
		operazioa = teklatua.nextInt();
		if (operazioa > 5) {
			System.out.println("Sartu operazio egokia.");
			teklatua.close();
			return;
		}
		System.out.println("Sartu lehenengo zenbakia: ");
		num_1 = teklatua.nextDouble();
		System.out.println("Sartu bigarren zenbakia: ");
		num_2 = teklatua.nextDouble();
		teklatua.close();
		switch(operazioa) {
			case 1:
				emaitza = num_1 + num_2;
				System.out.println("Emaitza: " +emaitza+ " da");
				break;
			case 2:
				emaitza = num_1 - num_2;
				System.out.println("Emaitza: " +emaitza+ " da");
				break;
			case 3:
				emaitza = num_1 * num_2;
				System.out.println("Emaitza: " +emaitza+ " da");
				break;
			case 4:
				if (num_2 != 0) {
					emaitza = num_1/num_2;
					System.out.println("Emaitza: " +emaitza+ " da");
				}else {
					System.out.println("Bigarren zenbakia ezin da izan 0!");
				}
				break;
			case 5:
				break;
		}	
	}
}

/* APUNTEAK */

/* 

-While(true) loop infinitu bat da. While hori, erabiltzen da denbora guztian funtzionatzeko. Loop infitu horrekin, programari esaten diogu menu-a egoteko denbora guztian aktibo 5- zenbabakia ukitu arte (Exit), hau if == 5 eta break;→(loop-a apurtzen du) batekin egin dezakegu. 

-Gero erabiltzen dugu beste while(true), infinitua ere, nahi dugulako erabilltzailea zenbaki egokia erabiltzea. Azken loop honetan, zenbaki bat irakurtzen du. Zenbakia 1 eta 5 artea badago, apurtzen du loop-a eta hurrengo pausura joaten da, zenbakia tarte horren kanpoan badago, errore bat jartzen du pantailan eta jarraitzen du saiatzen/eskatzen beste zenbaki bat. Horregaitik teklatua.next() erabiltzen dugu, balore hori garbitzeko eta kodea errepokatzeko beste balio bat sartzen. 

Laburpen moduan, erabiltzailea string bat edota beste zenbaki bat sartzen badu, programak hartzen du (catch erabiltzen) eta imprimatzen du errore mesu bat. “teklatua.next()” erabiltzen dugu garbitzeko “invalid input” input bufferratik.
HONA HEMEN AZALDU DUGUNA:
        while (true) {
            System.out.println("Sartu zer operazio egin nahi duzun: \n"
                    + "1 - Gehitu \n"
                    + "2 - Kenketa \n"
                    + "3 - Biderketa \n"
                    + "4 - zatiketa \n"
                    + "5 - irten");
            while (true) {
                try {
                    operazioa = teklatua.nextInt();
                    if (operazioa < 1 || operazioa > 5) {
                        System.out.println("Sartu menu zenbaki egokia.\n"
                                        + "1 - Gehitu \n"
                                + "2 - Kenketa \n"
                                + "3 - Biderketa \n"
                                + "4 - zatiketa \n"
                                + "5 - irten");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Sartu zenbaki bat.");
                    teklatua.next(); // Clear invalid input
                }

            }
            
  
 
While(true), beste kasu batzuetan erabili dezakegu. Adibidez zatiketan.
Zatiketan, ezin dugu eduki zatitzailean 0. NULL-a emango duelako ordun while(true) erabiliko dugu gero try and catch bat egiteko.
try(saiatu) num_2 ==0 && laugarren operazioa erabiltzen badugu (operazioa == 4) idatziko dugu ezin izango dela kalkulatu. EZ BADA KASU HORI ETA ONDO IDATZITA
BADAGO, apurtzen dugu eta joango gara eragiketa egitera. BAINA KASU HORI EMATEN BADA, hartuko dugu (catch) eta txarto dagoen input-a eta berriro eskatuko dugu zenbakia mesu batekin. Hori eta gero, garbitu teklatuaren input-a eta horrela errepikatzen.
*/