//MODU EGOKIENA HAU DA.
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

public class menu_1 {
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
     /* default:
      //si no es entre 1 y 5 que se rompa. Una vez terminado de pedir todo. Mejor poner lo de arriba
      	System.out.println("aukera baliogabea");*/
		}	
	}
}
