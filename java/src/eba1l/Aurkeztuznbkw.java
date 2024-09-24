package eba1l;
import java.util.Scanner;

public class Aurkeztuznbkw {
	public static void main(String[]args) {
		int n;
		int x;
		//While erabiltzen baduzu
		//x = 1;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Sartu zenbaki oso bat: ");
		n = teklatua.nextInt();
		teklatua.close();
		/*
		while (x < n) {
			System.out.println(x);
			x++;
		}*/
		//for erabilita
		for (x = 1 ; x<n; x++) {
			System.out.println(x);
		}
		//do while batekin
		/*
		do {
			System.out.println(x);
			x++;
		}while(x < n);
		*/
	}
}
