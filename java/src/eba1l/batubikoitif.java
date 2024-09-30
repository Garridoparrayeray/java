package eba1l;
import java.util.Scanner;

public class batubikoitif {
	public static void main(String[]args) {
		int n;
		int batura;
		int x;
		
		batura = 0;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Zenbaki oso bat ipini:");
		n = teklatua.nextInt();
		teklatua.close();
		while (n < 0) {
			System.out.println("Errore, zenbaki positibo oso bat ipini:");
			n = teklatua.nextInt();
		}
		for(x = 0; x <= n ;x+=2) {
			batura+=x;
			System.out.println(batura);
		}
	}
}
