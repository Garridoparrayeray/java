package eba1l;
import java.util.Scanner;
public class bisurte {
	public static void main(String[]args) {
		int urtea;
		
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Sartu urtea");
		urtea = teklatua.nextInt();
		teklatua.close();
		if (urtea >= 0) {
			if (urtea%400 == 0 || (urtea%4 == 0 && (urtea%100 !=0))) {
				System.out.println(urtea+" bisurtea da");
			}else {
				System.out.println(urtea+ " ez da bisurtea");
			}
		}else {
			System.out.println("Sartu ondo urteak, sakatu run botoia berriro sartzeko");
		}
	}
}
