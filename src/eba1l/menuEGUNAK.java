package eba1l;
import java.util.Scanner;
public class menuEGUNAK {
	public static void main(String[]args) {
		String egunak;
		//inizializatu behar duzu katea hasteko. NULL-ean hasiko zen ez badozu egiten
		/* BESTE MODU BATEAN IPINI DEZAKEGU WHILE(TRUE) BAT ETA TRY AND CATCH.*/
		egunak = new String();
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Asteko egun bat sartu: \n"
				+ "AL\n"
				+ "AA\n"
				+"AZ\n"
				+"0G\n"
				+"OL\n"
				+"LA\n"
				+"IG\n");
		egunak = teklatua.next();
		//BESTE MODU BATEAN:
		/*
		System.out.println("Asteko eguna sartu. Lehenengo izkia: ");
		egunak += teklatua.next().charAt(0);
		System.out.println("Asteko eguna sartu. Bigarren izkia: ");
		egunak += teklatua.next().charAt(0);*/
		teklatua.close();
		switch(egunak){
				case "AL":
					System.out.println("Astelehena");
					break;
				case "AA":
					System.out.println("Asteartea");
					break;
				case "AZ":
					System.out.println("Asteazkena");	
					break;
				case "0G":
					System.out.println("Osteguna");
					break;
				case "OL":
					System.out.println("Ostirala");
					break;
				case "LA":
					System.out.println("Larunbata");
					break;
				case "IG":
					System.out.println("Igandea");	
					break;
				default:
					System.out.println("Sartu sigla egokiak");
		}
		
		
	}

}
