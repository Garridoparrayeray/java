package eba1l;
import java.util.Scanner;
public class Irakurriznbk1 {
	public static void main(String[] args) {
		int n;
		//Sartu behar dut guztia hemen. Hau, izango da ejekutatuko dena.
		Scanner teklatua = new Scanner(System.in);
		/*Scanner sortzea. Sortu scanner bat sartzeko gauzak teklatuarekin, bere izena "teklatua" da.*/
		System.out.println("Sartu zenbaki bat: ");//Zer egitearen informazioa.
		n = teklatua.nextInt();//honekin, variable bat sortzen duzu ejekutatzeko funtzioa. Esaten diozu int zenbaki bat sartzeko
		teklatua.close();//teklatua itxi
		System.out.println(++n); //imprimaketa.
		System.out.printf("%d",++n);//imprimaketa printf erabiliz
	}
}
