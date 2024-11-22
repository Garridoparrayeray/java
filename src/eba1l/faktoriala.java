package eba1l;
import java.util.Scanner;

public class faktoriala {
	public static void main(String[]args) {
		int n;
		int i;
		long batura; // Overflow ebitatzeko zenbaki handiekin
		
		Scanner teklatua = new Scanner(System.in);
		while(true) {
			System.out.println("Sartu zenbaki bat: ");
			n = teklatua.nextInt();
			if(n >= 0) {
				break;
			} else {
				System.out.println("Sartu zenbaki positibo bat programa hasteko: ");
			}
			teklatua.close();
		}
		batura = 1;
		for(i = 1; i <= n; i++) {
			batura *= i;
		}
		System.out.println(n + "-ren faktoriala, " + batura + " da.");
	}
}