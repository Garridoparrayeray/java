package eba1l;
import java.util.Scanner;

public class MXN {
	public static void main(String[]args) {
		float n;
		//float zenbaki_falta;
		//zenbaki_falta = 0;
		Scanner teklatua = new Scanner(System.in);
		System.out.println("Kantitatea sartu");
		n = teklatua.nextFloat();
		n = (float)Math.pow(n, 2);//pasa behar duzu floatera(froga bezala), double eskatzen du.
		
		teklatua.close();
		if(n >/*=*/ 100) {//eragile logikoak horrela idazten dira ez =>
			System.out.println("zenbakia " + (n - 100) + " da");
		}else {
			/*while(n<100) {
				++n;
				zenbaki_falta++;
			}beste metodo bat. While batekin*/
			System.out.println((100 - n) + " zenbaki falta dira 100 ailegatzeko");

			//System.out.println(zenbaki_falta + " zenbaki falta dira 100 ailegatzeko");
		}
	}
}
