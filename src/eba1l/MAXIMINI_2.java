package eba1l;
import java.util.Scanner;

public class MAXIMINI_2 {
	public static void main(String[]args) {
		int	n;
		int	max;
		int	min;
		
		Scanner teklatua = new Scanner(System.in);
		
		System.out.println("Sartu zenbaki bat (sartu zenbaki negatibo bat programa ixteko): ");
		n = teklatua.nextInt();
		if (n < 0) {
			teklatua.close();
			System.out.println("Ez duzu sartu zenbaki positiborik hasteko programa.");
			return;
		}
		
		max = n;
		min = n;
		
		while(true) {
			System.out.println("Sartu zenbaki bat (sartu zenbaki negatibo bat programa ixteko): ");
			n = teklatua.nextInt();
			if (n < 0) {
				teklatua.close();
				break;
			}
			if(n < min) {
				min = n;
			}
			if(n > max) {
				max = n;
			}
		}
		System.out.println("Zenbaki positibo handiena " +max+ " izan da");
		System.out.println("Zenbaki positibo txikiena " +min+ " izan da");
	}
}