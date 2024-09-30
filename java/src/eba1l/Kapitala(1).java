package eba1l;
import java.util.Scanner;

public class Kapitala {
	public static void main(String[]args) {
		double diru_kantitatea; //inprezisoa izango da baina egokiena momentu honetan.
		double Interes_tasa;//% bat delako.
		int denbora_tartea;//egunetan delako
		double interesa;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Diru kantitatea sartu: ");
		diru_kantitatea = teklatua.nextDouble();
		System.out.println("Interes tasa sartu, ehunekoa: ");
		Interes_tasa = teklatua.nextDouble();
		System.out.println("Denbora tartea satu (egunetan): ");
		denbora_tartea = teklatua.nextInt();
		teklatua.close();
		interesa = Math.floor((diru_kantitatea * Interes_tasa * denbora_tartea)/(360*100));
		System.out.println("zure interesa %" +interesa+ "-koa da.");
		
		
	}
}
