package eba1l;
import java.util.Scanner;

public class ZIFRAK_1 {
	public static void main(String[]args) {
		long n;//sartutako zenbakia
		long zenbaki_bakarra;//zenbaki bat inprimatzeko
		//long alderantziz;//zenbakia alderantziz gordetzeko
		
		zenbaki_bakarra = 0;
		//alderantziz = 0;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Zenbaki bat sartu: ");
		n = teklatua.nextLong();
		teklatua.close();
		
		while(n > 0) {
			n /= 10;//zenbakia moldatu berriro hasteko
			System.out.println(zenbaki_bakarra);//zenbakia inprimatu
			zenbaki_bakarra = n % 10;//lehenengo zenbakia hartzeko
		}
	}
}
