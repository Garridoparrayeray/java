package ebal2;

import java.util.Scanner;

public class BATAZBESTETENP {
    public static void main(String[] args) {
        
        int[] znbk_array = new int[10];
        int znbk; // zenbakia gordetzeko aldagai tenporala
        int gehiketa = 0; // Guztizko batura gordetzeko aldagaia
        int contador = znbk_array.length; // Zenbat zenbaki falta diren jakiteko kontagailua
        int BATAZBESTE; // Batez bestekoaren emaitza gordetzeko aldagaia
        Scanner teklatua = new Scanner(System.in);

        // 10 tenperatura eskatu eta array-ean gorde
        for (int i = 0; i < znbk_array.length; i++) {
            System.out.println("Sartu temperatura bat: ");
            System.out.println(contador + " temperatura zenbaki falta zaizu");
            znbk = teklatua.nextInt();
            znbk_array[i] = znbk; 
            gehiketa += znbk; 
            contador--; 
        }

        // Batez bestekoa kalkulatu
        BATAZBESTE = gehiketa / znbk_array.length;
        System.out.println("Batazbestea: " + BATAZBESTE + "º");

        // Analisiari dagokion aldagaien hasieraketa
        int dif10 = 0; // 10ºko diferentzia duten zenbakien kontagailua
        int zero_aspitik = 0; // 0º azpiko zenbakien kontagailua
        String dif10List = ""; // 10ºko diferentzia duten zenbakien zerrenda
        String zero_aspitik_lista = ""; // 0º azpiko zenbakien zerrenda

        System.out.println("\n");

      
        for (int i = 0; i < znbk_array.length; i++) {
            // Batez bestekotik txikiago, handiago edo berdina den jakiteko
            if (znbk_array[i] < BATAZBESTE) {
                System.out.println("Zenbakia, " + znbk_array[i] + ", " + BATAZBESTE + " baino txikiagoa da");
            } else if (znbk_array[i] > BATAZBESTE) {
                System.out.println("Zenbakia, " + znbk_array[i] + ", " + BATAZBESTE + " baino handiagoa da");
            } else {
                System.out.println("Zenbakia, " + znbk_array[i] + ", " + BATAZBESTE + " berdina da");
            }

            // Batez bestetik 10º edo gutxiagoko diferentzia duten zenbakiak bilatu
            if (Math.abs(znbk_array[i] - BATAZBESTE) <= 10) {
                dif10++;
                dif10List += znbk_array[i] + " ";
            }

            // 0º azpiko zenbakiak bilatu
            if (znbk_array[i] < 0) {
                zero_aspitik++;
                zero_aspitik_lista += znbk_array[i] + "º" + " ";
            }
        }

        System.out.println("\n");

       
        System.out.println("Bataz bestetik 10ºko diferentzia dutenak: " + dif10);
        System.out.println("Portzentajea: " + ((double) dif10 / znbk_array.length * 100) + "%");
        System.out.println("Temperaturak: " + dif10List);

        System.out.println("\n");

        System.out.println("0º azpikoak: " + zero_aspitik);
        System.out.println("Portzentajea: " + ((double) zero_aspitik / znbk_array.length * 100) + "%");
        System.out.println("Temperaturak: " + zero_aspitik_lista);
        teklatua.close();
    }
}