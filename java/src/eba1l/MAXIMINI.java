package eba1l;
import java.util.Scanner;

public class MAXIMINI {
	public static void main(String[]args) {
		int	n;
		int	max;
		int	min;
		
		Scanner teklatua = new Scanner(System.in);
		//BESTE MODU BAT: 
		
		//max = Integer.MAX_VALUE;
		//min = Integer.MIN_VALUE;
		System.out.println("Sartu zenbaki bat (sartu zenbaki negatibo bat programa ixteko): ");
		n = teklatua.nextInt();
		if (n < 0) {
			teklatua.close();
			System.out.println("Ez duzu sartu zenbaki positiborik hasteko programa.");
			return;
		}
		//lehenengo zenbakia sartzean, handiena eta txikiena izango da
		max = n;
		min = n;
		while(true) {
			//base horrekin, minimoak eta maximoak atera.
			System.out.println("Sartu zenbaki bat (sartu zenbaki negatibo bat programa ixteko): ");
			n = teklatua.nextInt();
			if (n < 0) {
				teklatua.close();
				break;
			}
			if(n < max) {
				max = n;
			}
			if(n > min) {
				min = n;
			}
		}
		System.out.println("Zenbaki positibo handiena " +min+ " izan da");
		System.out.println("Zenbaki positibo txikiena " +max+ " izan da");
	}
}
