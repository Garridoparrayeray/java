package eba1l;
import java.util.Scanner;

public class gauzak {
	public static void main(String[]Args) {
		//kolorerik ez baina string bariablea horrela da
		String gauza_kod;
		int gauza_kop;
		double gauza_prezioa;
		//Scanner hasi eta bariableetan baloreak jarri
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Produktuaren kodea sartu: ");
		gauza_kod = teklatua.next();
		System.out.println("Produktuaren kopurua sartu: ");
		gauza_kop = teklatua.nextInt();
		System.out.println("Produktuaren prezioa sartu: ");
		gauza_prezioa = teklatua.nextDouble();
		teklatua.close();
		if(gauza_kop <= 10) {
			System.out.println(gauza_kod + " Ez dauka beherapenik "+gauza_kop+" kopuruarekin");//ez du behar printf-a
		}else if(gauza_kop > 10 && gauza_kop <= 25){
			gauza_prezioa = gauza_prezioa * 0.10;
			//printf moduan, 2 hamartar ipini dezaket edota string.format batekin
			/*
			 * Modu honetan String.format erabiltzen dugu gauza berdinarako
			 * System.out.println(String.format("%s %.2f€-ko beherapena daukazu %d kopuruarekin", gauza_kod, gauza_prezioa, gauza_kop));
			 * BESTE MODU BAT LERRO BATEAN EGITEKO
			 * System.out.println(gauza_kod + gauza_prezioa*0.10 + " beherapena daukazu " +gauza_kop+ " kopuruarekin");
			 */
			 System.out.printf("%s %.2f€-ko beherapena daukazu %d kopuruarekin%n", gauza_kod, gauza_prezioa, gauza_kop);	
		}else if(gauza_kop > 25 && gauza_kop <= 100) {
			gauza_prezioa = gauza_prezioa * 0.20;
			 System.out.printf("%s %.2f€-ko beherapena daukazu %d kopuruarekin%n", gauza_kod, gauza_prezioa, gauza_kop);	
		}else {
			gauza_prezioa = gauza_prezioa * 0.40;
			 System.out.printf("%s %.2f€-ko beherapena daukazu %d kopuruarekin%n", gauza_kod, gauza_prezioa, gauza_kop);	
		}
	}
}
