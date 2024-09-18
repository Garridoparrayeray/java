package eba1l;

import java.util.Scanner;

public class Kuboa {
	public static void main(String[]args) {
		double r;//honekin derrigorrez funtzionatzeko Math.pow. (double, double)  -> (base, exponentziala).
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Sartu zenbaki oso bat: ");//Zer egitearen informazioa.
		r = teklatua.nextInt();
		r = Math.pow(r, 3);
		/*
		 n = n*n*n; -> kuboa egiteko nª3
		 n = n**3; eragiteka berdina egiteko erabiltzen da Java 14tik gorantz 
		 */
		teklatua.close();
		System.out.println("Kuboa "+r+" da");
		//System.out.printf("kuboa %2f da", r);
	}

}
