package eba1l;
import java.util.Scanner;
public class notabal {
	public static void main(String[]args) {
		double nota;
		
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Nota sartu: ");
		nota = teklatua.nextDouble();
		teklatua.close();
		if (nota >=0 && nota <= 10) {
			//System.out.printf("%.0f nota zuzena da", nota);//0.f para que no tenga decimales
			System.out.println(+nota+" nota zuzena da");
		}else {
			System.out.println("nota ez da zuzena");
		}
		
	}
}
