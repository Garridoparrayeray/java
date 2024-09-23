package eba1l;
import java.util.Scanner;

public class soldataret {
  public static void main(String[] args) {
    float soldata;
    float atxikipena;
    float soldata_erreala;

    atxikipena = 0;

    Scanner teklatua = new Scanner(System.in);

    System.out.print("Sartu langilearen soldata: ");
    soldata = teklatua.nextFloat();
    teklatua.close();

    if (soldata < 1000) {
	//atxikipena %10
      atxikipena = soldata * 0.10f;//0.10f da horrela float delako. Double baldin bada, f gabe. 0.10
    } else if (soldata == 1000) {
	//atxikipena %12
      atxikipena = soldata * 0.12f;
    } else {
	//atxikioena %14
      atxikipena = soldata * 0.14f;
    }

    //soldata_erreala = soldata - atxikipena;

    //System.out.println("Soldata garbia: " + soldata_erreala);
    //modu garbiago batean eginda:
    System.out.println("SOldata garbia: " + (soldata - atxikipena);
  }
}
