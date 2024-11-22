package ebal2;
import java.util.Scanner;
 
public class BATAZBESTE {
    public static void main(String[] args) {
        int znbk_array[];
        int gehiketa;
        int contador;
        double  BATAZBESTE;
        double desbideratzetipikoa;
        double karratu_gehiketa;
        znbk_array = new int[10];
        gehiketa = 0;
        contador = znbk_array.length;
        karratu_gehiketa = 0;
        desbideratzetipikoa = 0;

        Scanner teklatua = new Scanner(System.in);
        
        for(int i = 0; i < znbk_array.length - 1; i++){
            System.out.println("Sartu zenbaki bat: ");
            System.out.println(contador + " zenbaki falta zaizu");
            znbk_array[i] = teklatua.nextInt();
            gehiketa += znbk_array[i];
            contador--;
        }

        //BATAZBESTEKOA
        BATAZBESTE = gehiketa / znbk_array.length;
        System.out.println("Batazbestea: " + BATAZBESTE);
        teklatua.close();

        System.out.println('\n');
        System.out.println('\n');
       
        //DESBIDERATZE TIPIKOA
            //FORMULA -> SUMATORIO((GELAXKA BAKOITZEKO ZENBAKIA - BATAZBEZTE)^2)
        for(int i = 0; i < znbk_array.length; i++){
            karratu_gehiketa += Math.pow((znbk_array[i] - BATAZBESTE), 2);
        }
        desbideratzetipikoa = Math.sqrt(karratu_gehiketa/znbk_array.length);
        System.out.println("Desbideratze tipikoa " + desbideratzetipikoa + " da");
        System.out.println('\n');
        System.out.println('\n');
       
        int gora= 0;
        int behera = 0;
        /*ZENBAKIAK BATAZBEZTE GOHIAN ETA BEHAN */
        	for(int i = 0; i < znbk_array.length;i++) {
        		 if(znbk_array[i] < BATAZBESTE){
               gora++;
		         }else if(znbk_array[i] > BATAZBESTE){
		             behera++;
		         }else {
		        	System.out.println("Zenbakia, " + znbk_array[i]+  ", "+ BATAZBESTE + " berdina da");
		         }
        	}
        	System.out.println("Zenbakia, " + gora +  ", "+ BATAZBESTE + " baino handiagoak dira");
        	System.out.println("Zenbakia, " + behera +  ", "+ BATAZBESTE + " baino txikiagoak dira");
        	
        /*for(int i = 0; i < znbk_array.length; i++){
            if(znbk_array[i] < BATAZBESTE){
                System.out.println("Zenbakia, " + znbk_array[i]+  ", "+ BATAZBESTE + " baino txikiagoa da");
            }
           
        }
        System.out.println('\n');

        for(int i = 0; i < znbk_array.length; i++){
            if(znbk_array[i] > BATAZBESTE){
                System.out.println("Zenbakia, " + znbk_array[i]+  ", "+ BATAZBESTE + " baino handiagoa da");
            }
        }*/
    }
}