package eba1l;
import java.util.Scanner;

public class batuznbkw_2 {
	public static void main(String[]args) {
		int n;
		int batura;
		int x;
		
		batura = 0;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Zenbaki bat idatzi: ");
		n = teklatua.nextInt();
		teklatua.close();
		for(x = 0;x<=n;x++) {
			batura += x;
			System.out.println(batura);
		}
		//while metodoa
		/*while(x <= n) {
			batura = x + batura;
			System.out.println(batura);
			x++;
		}*/
		//do while metodoa
		/*do {
			batura = x + batura;
			System.out.println(batura);
			x++;
		
		}while(x <= n);*/
	}
}
