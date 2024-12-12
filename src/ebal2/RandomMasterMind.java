package ebal2;

import java.util.Random;
import java.util.Scanner;

/* Wordle modukoa baina zenbakiekin. Klasean emandako materialarekin. Klaseak, konstruktoreak, try & catch, random, String-ak, etab erabilia. Hurrengo implementazioa: log guztioak doc batean jartzea*/
public class RandomMasterMind {
	private String ZenbakiSekretua;//posizio bidez egiteko zenbakia.
	private String asmakuntza;
	public RandomMasterMind(){//konstruktorea
		this.ZenbakiSekretua = ZenbakiSekretuaSorgailua(); 
	}
	
	private String ZenbakiSekretuaSorgailua() {//sorgailu tipikoa. Random-arekin
		int zenbakia;
		Random rnd = new Random();
		zenbakia = ((int)(rnd.nextDouble()*100000))%10000 + 100;
		//beste modu batean:
		//zenbakia = (int)(Math.random()* 100000) % 1000;
		
		return String.format("%04d", zenbakia);//Zenbakiaren sorgailua. Beharrezkoa da 0 hori jartzea, errorea ematen du (hiru digito agertzen dira bakarrik) ez baduzu jartzen(ez dakit zergatik)
	}
	
	public String AsmakuntzaFrogak(String asmakuntza) {//posizioan eta zenbakia asmatzeko frogak
		int asmatutakoPosizioa;
		int asmatutakoZenbakia;
		
		asmatutakoPosizioa = 0;
		asmatutakoZenbakia = 0;
		
		for (int i = 0; i < 4; i++) {
            if (ZenbakiSekretua.charAt(i) == asmakuntza.charAt(i)) {//posizio berean badaude...
                asmatutakoPosizioa++; // Posizio zuzenak
            } else if (ZenbakiSekretua.contains(String.valueOf(asmakuntza.charAt(i)))) {//zenbaki berdina eta posizio berean badago
                asmatutakoZenbakia++; // Digito zuzenak
            }
        }
		return "Digito zuzenak: " + (asmatutakoZenbakia + asmatutakoPosizioa) + " dira" + ", posizio zuzenak: " + asmatutakoPosizioa + " dira";
		
	}
	//erabili nahi badugu berriro beste leku batean, public moduan ipintzen dugu
	public void Jokoa() {
		int AsmakuntzaMax = 10;
		Scanner teklatua = new Scanner (System.in);
		while (AsmakuntzaMax > 0) {
			System.out.println(ZenbakiSekretua);
			try {
				System.out.println("Sartu 4 digitoko zenbaki bat: ");
				asmakuntza = teklatua.nextLine();
				
				if (asmakuntza.length() != 4) {
		                throw new NumberFormatException("Zenbakia, 4 DIGITOKO zenbaki bat izan behar da");
		         }
				if(asmakuntza.equals(ZenbakiSekretua)) {
					System.out.println("Lortu duzu! Asmatzeko zenbakia " + asmakuntza + " zen");
					BerriroJokatu(teklatua);
					return;
				}else {
					System.out.println(AsmakuntzaFrogak(asmakuntza));
				}
				
				AsmakuntzaMax--;
				
				System.out.println(AsmakuntzaMax + " falta dira");
			
			}catch(NumberFormatException e) {
				System.out.println("Sartu ZENBAKI POSITIBO bat.");
				teklatua.nextLine();//buffer-a garbitzeko (badaezpada)
			}
				
		}
		
		System.out.println("Ez duzu asmatu, zure zenbaki sekretua " + ZenbakiSekretua + " zen");
		BerriroJokatu(teklatua);
	}
	
	public void BerriroJokatu(Scanner teklatua) {//konstruktore Scanner, objektu teklatua deitzen dut. Berriro jokatzeko, funtzio berdinean ipintzen banuen, bi aldiz eskatzen zidan zenbakia.
		int prog;
		while(true) {
			try {
				System.out.println("Berriro jokatu nahi duzu?\n" +
									"Idatzi 1 jarraitu nahi baduzu \n" +
									"Idatzi 0 amaitu nahi baduzu ");
				prog = teklatua.nextInt();
				if(prog == 1) {
					ZenbakiSekretua = ZenbakiSekretuaSorgailua();//berritu zenbakia
					Jokoa();//berritu jokoa
					return;
				}else if (prog == 0) {
					System.out.println("Programa ixten...");
					break;
				}else {
					System.out.println("Sartu 1 edo 0");
				}
			}catch(NumberFormatException e) {
				System.out.println("Sartu ZENBAKI POSITIBO bat 1 edo 0 artekoa.");
				teklatua.nextLine();
			}
		}
		teklatua.close();
	}
	
	public static void main (String[]args) {//main-a
		RandomMasterMind jokoa = new RandomMasterMind();//deitzen dut klase printzipalera
		jokoa.Jokoa();
		
	}
	
}
