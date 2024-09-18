package eba1l;
import java.util.Scanner;

public class Osoahamartar_1 {
    public static void main(String[] args) {
        double n;
        long int_osoa;
        String hamartarParteaString;
        Scanner teklatua = new Scanner(System.in);
        System.out.println("Zenbaki bat jarri: ");
        n = teklatua.nextDouble();
        /*osoaren partea hartu*/
        int_osoa = (int)n;//int moduan trunkatu, forzado a int desde double
        teklatua.close();
        /*Hamartar partea hartu*/
        double hamartarPartea = n - int_osoa;
        System.out.println("Osoa partea: " + int_osoa);
        hamartarParteaString = String.format("%.3f", hamartarPartea);//hiru hamartar frogatzeko
        hamartarParteaString = hamartarParteaString.replace("0,", ""); // Kentzeko hamartar puntua
        System.out.println("Hamartar partea: " + hamartarParteaString);
        /*System.out.println("Zenbakiaren osoa: " + ((int) n));
         	System.out.println("Zenbakiaren ondarra: + (n % 1));
         	System.out.println("Zenbakiaren ondarra: + (n - (int)n);
         	System.out.printf("Zenbakiaren ondarra: %f\n", (n % 1));
        */
    }
}