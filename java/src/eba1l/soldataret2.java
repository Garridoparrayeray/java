package eba1l;
import java.util.Scanner;

public class soldataret2 {
  public static void main(String[] args) {
    float soldata;
    float atxikipena;
    float soldata_erreala;
    atxikipena = 0;

    Scanner teklatua = new Scanner(System.in);

    System.out.println("Sartu langilearen soldata: ");
    soldata = teklatua.nextFloat();
    teklatua.close();

    if (soldata < 1000) {
      atxikipena = soldata * 0.10f;//0.10f da horrela float delako. Double baldin bada, f gabe. 0.10
    } else if (soldata == 1000) {
      atxikipena = soldata * 0.12f;
    } else if (soldata > 1000 && soldata < 2000) {
      atxikipena = soldata * 0.14f;
    } else if (soldata == 2000) {
    	atxikipena = soldata * 0.16f;
    } else if (soldata > 2000) {
    	atxikipena = soldata * 0.18f;
    }
    soldata_erreala = soldata - atxikipena;

    System.out.println("Soldata garbia: " + soldata_erreala);
  }
}