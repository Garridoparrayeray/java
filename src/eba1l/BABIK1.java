package eba1l;
import java.util.Scanner;

public class BABIK1 {
  public static void main(String[] args) {
  	int zenbaki;
    // Teklatutik zenbaki bat irakurri
    Scanner teklatua = new Scanner(System.in);
    System.out.print("Sartu zenbaki bat: ");
    zenbaki = teklatua.nextInt();
    teklatua.close();
    // Zenbakia bakoitia edo bikoitia den erabaki
    if (zenbaki % 2 == 0) {
      System.out.println("Zenbakia" +zenbaki+ " bikoitia da");
    } else {
      System.out.println("Zenbakia" +zenbaki+ " bakoitia da");
    }
   // System.out.printf("Zenbakia %d %s da%n", zenbaki, (zenbaki % 2 == 0) ? "bikoitia" : "bakoitia");
    //printfrekin egin dezakegu. Beste modu batean luzeago (errepasatu)
  }
}