package eba1l;
import java.util.Scanner;

public class multaula {
	public static void main(String[]args) {
		int i;
		int n;
		
		Scanner teklatua = new Scanner(System.in);
	
		System.out.println("Sartu zenbaki bat: ");
		n = teklatua.nextInt();
		teklatua.close();
		System.out.println(n +" Zenbakiaren biderketa taula: ");
		for(i = 0; i<=10 ; i++) {
			System.out.println(n + " x " + i + " = " + (n * i));
		}
	}
}
