package eba1l;

import java.util.Scanner;

public class batubikbw {
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
		if(n < 0) {
			do {
				System.out.println("Erorre. Zenbaki positibo bat idatzi: ");
				n = teklatua.nextInt();	
			}while(n<0);
		}

		/*BESTE MODU BAT:
		while (n < 0)
		{
			System.out.println("Erorre. Zenbaki positibo bat idatzi: ");
			n = teklatua.nextInt();		
		}
		*/
    do {
      batura += x; // Add x baturari
      x += 2; // Jarri x 2 emateko hurrengo zenbaki handia
      System.out.println(batura);
  } while (x <= n);
			//Beste modu bat:
			//batura = batura + x;
    //baina hau izango zen if batekin if(x % 2 ==0)

	}
}