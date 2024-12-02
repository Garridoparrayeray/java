package ebal2;

public class Zenbaketa {
	private String Izena;
	private int kopurua;
	private static int zenbat = 0;
	
	public Zenbaketa(String izena, int kopurua){
		this.Izena = izena;//aqui introducimos los valores que pidamos
		this.kopurua = kopurua;//mismo que izena
		zenbat++;//hago una funcion que llame todos los atributos y dependiendo de cuantos meta me sumara zenbat depende de las veces que llame zenbat e izena
		//me va a ir sumando el contador ESTO VA A SER AL IR SUMANDO LOS OBJETOS. CUANTOS MAS OBJETOS HAYA, MAS NUMERO HABRÁ
	}
/* LOS GETTERS Y SETTERS se hacen con Izena y kopurua ya que son los valores que se van a cambiar
 	 a lo largo del codigo zenbat es un static entonces no hace nada*/
	/*GETTERS Y SETTERS*/
	public String getIzena() {
		return Izena;
	}

	public void setIzena(String izena) {
		Izena = izena;
	}

	public int getKopurua() {
		return kopurua;
	}

	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}
	public static int getZenbat() {
		return zenbat;
	}
	
	

}
