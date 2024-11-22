package eba1l;
import java.util.Scanner;

public class batuznbkw {
	public static void main(String[]args) {
		int n;
		int batura;
		int x;
		
		batura = 0;
		x = 0;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Zenbaki bat idatzi: ");
		n = teklatua.nextInt();
		teklatua.close();
		
		while(x <= n) {
			batura = x + batura;
			System.out.println(batura);
			x++;
		}
		//do while metodoa
		/*do {
			batura = x + batura;
			System.out.println(batura);
			x++;
		
		}while(x <= n);*/	
	}
}
