package eba1l;
import java.util.Scanner;

public class KALKUBEZ {
	public static void main(String[]args) {
		float n;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Kantitatea sartu");
		n = teklatua.nextFloat();
		teklatua.close();
		if(n >/*=*/ 20000) {//eragile logikoak horrela idazten dira ez =>
			System.out.println("16%");
		}else {
			System.out.println("%7");
		}
	}
}
