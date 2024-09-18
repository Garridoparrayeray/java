package eba1l;
import java.util.Scanner;

public class Znbkbikoitza {
	public static void main(String[]args) {
		int n;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Sartu zenbaki bat: ");//Zer egitearen informazioa.
		n = teklatua.nextInt() * 2;
		teklatua.close();
		System.out.println(n);
	}
}
