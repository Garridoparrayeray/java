package eba1l;
import java.util.Scanner;

public class Fibonacci {
	public static void main(String[]args) {
			int n;
			int a;//f[0]
			int b;//f[1]
			int temp;//f[n] = f[n-1] + f[n-2]
			int i;
			
			//inizializatu
			a = 0;
			b = 1;
			Scanner teklatua = new Scanner(System.in);
			System.out.println("idatzi fibonacci sekuentziatik inprimatu nahi duzun zenbaki kopurua: ");
			n = teklatua.nextInt();
			teklatua.close();
			System.out.println("Lehenengo  fibonacciko " +n+ " zenbakiak hauek dira: ");
	    for (i = 0; i < n; i++) {
	      System.out.print(a + " ");
	      temp = a;
	      a = b;
	      b = temp + b;
	  }
	}
}
