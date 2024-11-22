package eba1l;
import java.util.Scanner;

public class zifrak {
	public static void main(String[]args) {
		int n;//sartutako zenbakia
		int zati;
		int luzeera;
		int emaitza;
		
		zati = 0;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Zenbaki bat sartu: ");
		n = teklatua.nextInt();//zenbakia eskatu
		teklatua.close(); 	
		luzeera = String.valueOf(n).length();//1234 = 4 zifra dira ordun luzeera = 4.
		
		for(int i = luzeera - 1; i >= 0; i--) {
		  zati = n / (int)Math.pow(10, i);//1234/ 10^4 izango zen.
	    emaitza = zati % 10;//ondarra ateratzeko
			System.out.println(emaitza);
		}
	}
}
