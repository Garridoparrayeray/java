package eba1l;
import java.util.Scanner;

public class Irakurrikarakterea {
	public static void main(String[]args) {//erabiltzeko beharrezkoa. Inoiz ahaztu behar dut
		char c;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Sartu karaktere bat");
		c = teklatua.next().charAt(0);//posizio 0-a irakurriko dugu
		teklatua.close();//Beti itxi behar da
		System.out.printf("Aldagaren balioa %c da", c);//format, arguments
	}
}
