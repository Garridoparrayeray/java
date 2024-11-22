package eba1l;
import java.util.Scanner;

public class batuzznbk {
	public static void main(String[]args) {
		int n;
		int batura;
		int x;
		
		batura = 0;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Zenbaki bat idatzi: ");
		n = teklatua.nextInt();
		do {
			System.out.println("Erorre. Zenbaki positibo bat idatzi: ");
			n = teklatua.nextInt();	
		}while(n<0);
		/*BESTE MODU BAT:
		while (n < 0)
		{
			System.out.println("Erorre. Zenbaki positibo bat idatzi: ");
			n = teklatua.nextInt();		
		}
		*/
		teklatua.close();
		for(x = 0;x<=n;x++) {
			batura += x;
			//Beste modu bat:
			//batura = batura + x;
			System.out.println(batura);
		}
	}
}
