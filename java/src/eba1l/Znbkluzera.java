package eba1l;
import java.util.Scanner;

public class Znbkluzera {
	public static void main(String[]args) {
		double r;
		double formula;
		//double PI;
		//PI = 3.1416;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Sartu erradioa: ");//Zer egitearen informazioa.
		r = teklatua.nextDouble();
		teklatua.close();
		formula = r*r*Math.PI;//Math.pow(r, 2) * Math.PI;
		//System.out.println("Azalera "+2*r*PI+" da");
		System.out.println("Azalera "+r*r*Math.PI+" da");//MathPI pi-ko bariablea da.
		System.out.printf("Azalera %.3f da", formula);//hiru hamartar
	}
}