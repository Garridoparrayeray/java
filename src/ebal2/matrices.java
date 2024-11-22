package ebal2;

public class matrices {
	public static void main(String[]args) {
		int[][] matriz = {{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6}, {1,2,3,4,5,6}, {1,2,3,4,5,6}};
		for(int i= 0; i < matriz.length; i++) {//matrizeko lenght-a eta gero i-ko lenght-a hartu behar dugu. Getrowcount eta gero for rowcount horiekin
			for(int j = 0; j < matriz[i].length; j++) {
				System.out.printf("%4d", matriz[i][j]);
			
			}
			System.out.println("");//System.out.println();System.out.println("\n");BESTE MODU BI
		}
				
		//int[][] matriz = new int[6][5];//EZ. E= 6(6 errenkada), Z = 5 (5 ZUTABE)
		/*-----------HASIERATU GABE----------
		for(int i= 0; i < matriz.length; i++) {//matrizeko lenght-a eta gero i-ko lenght-a hartu behar dugu. Getrowcount eta gero for rowcount horiekin
			for(int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = -1;
				System.out.printf("%d", matriz[i][j]);
			}
			System.out.println();
		}*/
		/*--------------BESTE MODU BATEAN-------*/
		/*for(int i= 0; i < 6; i++) {
			for(int j = 0; j < 5; j++) {
				matriz[i][j] = -1;
				System.out.printf("%d", matriz[i][j]);
			}
			System.out.println();
		}*/
	}
}