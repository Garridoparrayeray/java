package eba1l;
import java.util.Scanner;

public class KALKULAGAILUA {
	public static void main(String[]args) {
		int num1;
		int num2;
		
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Lehenengo zenbakia eskatu: ");
		num1 = teklatua.nextInt();
		
		System.out.println("Bigarren zenbakia eskatu: ");
		num2 = teklatua.nextInt();
		teklatua.close();
		
		System.out.println("batuketa da: " + batuketa(num1, num2));
		System.out.println("kenketa da: " + kenketa(num1, num2));
		System.out.println("batuketa da: " + biderketa(num1, num2));
	}
	private static int batuketa(int num1, int num2) {
		return num1 + num2;
	}
	private static int kenketa(int num1, int num2) {
		return num1 - num2;
	}
	private static int biderketa(int num1, int num2) {
		return num1 * num2;
	}
}

