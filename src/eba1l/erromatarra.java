package eba1l;
import java.util.Scanner;

public class erromatarra {
	public static void main(String[]args) {
		int zenb;
		Scanner teklatua = new Scanner(System.in);
		String zenbaki_hamartar = "";
		int [] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String unitatea[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		System.out.println("Sartu zenbakia 1 eta 999 artean: ");
		zenb = teklatua.nextInt();
		teklatua.close();	
		for(int i = 0; i < n.length; i++) {
			while(zenb >= n[i]) {
				zenbaki_hamartar += unitatea[i];
				zenb -= n[i];	
			}
		}
		System.out.println(zenbaki_hamartar);
	}
}
