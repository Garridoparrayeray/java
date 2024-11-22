package eba1l;

public class lehenengo100zenbaki {
	public static void main(String[]args) {
		int x;
		x = 1;
		//Hasierako zenbakia; amaierako zenbakia;gehikuntza
		/*
		 for(x = 1; x <= 100; x++) {
			System.out.println(x);
		}
		*/
		
		//do while batekin horrela izango zen
		/*
		 do {
			System.out.println(x);
			x++;
		}while(x < 100);*/
		
		//while batekin
		
		 /*while(x < 100) {
			System.out.println(x++);
		}
		*/
		
		//while(true)
		
		 while(true) {
			if(x <= 100) {
				System.out.println(x);
				x++;
			}else {
				break;
			}
		}
		
	}
	
}
