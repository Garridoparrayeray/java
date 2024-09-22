package eba1l;
import java.util.Scanner;

public class segundo {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        int ordua;
        int minutuak;
        int segunduak;

        Scanner teklatua = new Scanner(System.in);

        /* ADIBIDE POSIBLEA 1
         
    
        while (true) {//errore posibleak
            System.out.println("Sartu orduak: ");
            ordua = teklatua.nextInt();
            System.out.println("Sartu minutuak: ");
            minutuak = teklatua.nextInt();
            System.out.println("Sartu segunduak: ");
            segunduak = teklatua.nextInt();

            if (ordua >= 0 && ordua <= 23 && minutuak >= 0 && minutuak <= 59 && segunduak >= 0 && segunduak <= 59) {
                break;//inportantea, while batekin ezin dugu egin. Boolean bakarrik
            } else {
                System.out.println("Error: sartu ongi denbora.");
            }
        }*/
        System.out.print("Sartu orduak: ");
        ordua = teklatua.nextInt();
        // baloreak doitu
        if (ordua < 0 || ordua > 23) {
            System.out.println("Error: ordua txarto dago, sakatu botoia berriro sartzeko");
            return;
        }
        System.out.print("Sartu minutuak: ");
        minutuak = teklatua.nextInt();
        if (minutuak < 0 || minutuak > 59) {
            System.out.println("Error: minutuak txarto daude, sakatu botoia berriro sartzeko");
            return;
        }
        System.out.print("Sartu segunduak: ");
        segunduak = teklatua.nextInt();
        if (segunduak < 0 || segunduak > 59) {
            System.out.println("Error: segunduak txarto daude, sakatu botoia berriro sartzeko");
            return;
        }
        teklatua.close();
        // gehitu segunduak
        segunduak++;

        // doitu baloreak
        if (segunduak == 60) {
            segunduak = 0;
            minutuak++;
        }
        if (minutuak == 60) {
            minutuak = 0;
            ordua++;
        }
        if (ordua == 24) {
            ordua = 0;
        }

        System.out.println("Zure ordua: " + ordua + "h " + minutuak + "min " + segunduak + "s da");
    }
}