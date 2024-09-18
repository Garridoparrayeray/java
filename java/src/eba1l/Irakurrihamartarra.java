package eba1l;
import java.util.Scanner;
public class Irakurrihamartarra {
	public static void main(String[]args) {
		double n;
		Scanner teklatua = new Scanner(System.in);
		n = teklatua.nextDouble();
		System.out.println("Sartu zenbaki hamartar bat");
		teklatua.close();
		System.out.println("Zure zenbakia"+n+"da");
	}
}
