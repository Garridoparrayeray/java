package eba1l;
import java.util.Scanner;

public class aurkeztubikw {
	public static void main(String[]args) {
		int n;
		int x;
		//hasierako zenbakia. Scannerrarekin konparatzeko
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Sartu zenbaki bat: ");
		n = teklatua.nextInt();
		teklatua.close();
		x = n;
		while (x != 0) {
			x--;
			/*behar dugu baldintza == 0 MOD funcionatzeko */
			if(x % 2 == 0) {
				System.out.println(+x+ " Bikoitia da");
			}
		}
	}
}
