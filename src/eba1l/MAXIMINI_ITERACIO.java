package eba1l;
import java.util.Scanner;
 
public class MAXIMINI_ITERACIO {
	public static void main(String[] args) {
		Scanner teklatua = new Scanner(System.in);
		int x, max, min, n;		
		n = 0;
		max=0;
		min=0;	
		do {
			System.out.print("zenbaki bat sartu: ");
			x = teklatua.nextInt();
			if (x >= 0) {
				if (n == 0) {
					max = x;
					min = x;
					}
				else {
					if (x > max) {
						max =  x;	
					}
					else if (x < min) {
						min = x;
					}
				}
				n++;
			}
		}while (x >= 0);		
		System.out.println(max + " zenbaki handiena da.");
		System.out.println(min + " zenbaki txikiena da.");
		teklatua.close();
	}
}