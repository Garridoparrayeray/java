package ebal2;
import java.util.Scanner;

public class ZENBATZNBK {
    public static void main(String[] args) {

	      // Gehien eta gutxien sartu direnak
	      int gehien = 1;
	      int gutxien = 1;
        Scanner scanner = new Scanner(System.in);
        int[] Maiztasunak;
        Maiztasunak = new int[5];
        int zenbaki;
     
        do{
            System.out.println("Sartu 1etik 5erako zenbakiak (0 irten nahi baduzu):");
            zenbaki = scanner.nextInt();
             if (zenbaki > 0 && zenbaki < 6) {
                Maiztasunak[zenbaki - 1]++;
            } else {
                System.out.println("Mesedez, sartu 1etik 5era arteko zenbaki bat.");
            }
        }while(zenbaki != 0);
        
        // Maiztasunen irteera
        System.out.println("Maiztasunak:");
        for (int i = 0; i < Maiztasunak.length; i++) {
            System.out.println((i + 1) + ": " + Maiztasunak[i] + " aldiz");
            if (Maiztasunak[i] > gehien) {//gehien = 0 handiago bada Maiztasunaren posizioa baino, sartzen da gehienen. Horrela handixea aurkitu arte
              gehien = Maiztasunak[i];
          }else if (Maiztasunak[i] < gutxien){//gehien modukoa baina aldrebes. Horrela txikiena aurkitu arte. 
              gutxien = Maiztasunak[i];
          }else if(Maiztasunak[i] == 0){
              System.out.println("ez sartutakoak "+ (i + 1) + "dira");
          }
        }

        System.out.println('\n');
        System.out.println("Gehien sartutakoa: " + (gehien + 1));//gehien + 1 posizio erreala ateratzeko. 0 posizioan badago(1 zenbakia), + 1 egiten da 1 ateratzeko
        System.out.println("Gutxien sartutakoa: " + (gutxien + 1));
        scanner.close();
    }
}