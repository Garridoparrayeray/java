package ebal2;

public class Auto {
	private String modeloa;
	private String matrikulua;
	private String kolorea;
	private int plaza_kopurua;
	private int zaldi_kopurua;
	private char erregai_mota;
	
	/*KONSTRUKTOREA GETTER ETA SETTER EGITEKO*/
	public static void main(String[]args) {
		Auto nireAutoa = new Auto();
		Auto nireAutoaDatuekin = new Auto("Toyota Yaris", "1234ABC");
		nireAutoa.setMatrikulua("1234ABC");
		System.out.println(nireAutoa.getMatrikulua());
		System.out.println(nireAutoa.matrikulua);/*Este está peor*/
		nireAutoaDatuekin.setMatrikulua("7865LZZ");
		System.out.println(nireAutoaDatuekin.getMatrikulua());
		Auto autoaKopia = new Auto(nireAutoa);//kopia bat sortzeko. Instantzia bat autoaren objektuaren datuak deko. Autoaren kopia guztiak
		
	}
	public Auto() {
		
	}
	public Auto(Auto a) {
		this.matrikulua = a.matrikulua;
		this.erregai_mota = a.erregai_mota;
		this.kolorea = a.kolorea;
		this.plaza_kopurua = a.plaza_kopurua;
		this.zaldi_kopurua = a.zaldi_kopurua;
		
	}
	
	public Auto(String modelo2, String matrikulo2) {
		this.matrikulua = matrikulo2;
		this.modeloa = modelo2;
	}
	
	public String getModeloa() {
		return modeloa;
	}
	public void setModeloa(String modeloa) {
		this.modeloa = modeloa;
	}
	public String getMatrikulua() {
		return matrikulua;
	}
	public void setMatrikulua(String matrikulua) {
		this.matrikulua = matrikulua;
	}
	public String getKolorea() {
		return kolorea;
	}
	public void setKolorea(String kolorea) {
		this.kolorea = kolorea;
	}
	public int getPlaza_kopurua() {
		return plaza_kopurua;
	}
	public void setPlaza_kopurua(int plaza_kopurua) {
		this.plaza_kopurua = plaza_kopurua;
	}
	public int getZaldi_kopurua() {
		return zaldi_kopurua;
	}
	public void setZaldi_kopurua(int zaldi_kopurua) {
		this.zaldi_kopurua = zaldi_kopurua;
	}
	public char getErregai_mota() {
		return erregai_mota;
	}
	public void setErregai_mota(char erregai_mota) {
		this.erregai_mota = erregai_mota;
	}
	
	
}
